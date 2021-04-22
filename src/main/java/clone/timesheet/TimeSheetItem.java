package clone.timesheet;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TimeSheetItem {

//    private Employee employee;          // referencia tipusú
    private String employee;
    private String project;             // immutable
    private LocalDateTime from;
    private LocalDateTime to;

    public TimeSheetItem(String employee, String project, LocalDateTime from, LocalDateTime to) {
        this.employee = employee;
        this.project = project;
        this.from = from;
        this.to = to;
    }

    public TimeSheetItem(TimeSheetItem anotherTimeSheetItem) {
        employee = anotherTimeSheetItem.employee;                          // shallow copy
        project = anotherTimeSheetItem.project;
        from = anotherTimeSheetItem.from;
        to = anotherTimeSheetItem.to;
    }

    /*
    public TimeSheetItem(TimeSheetItem anotherTimeSheetItem) {
        employee = new Employee(anotherTimeSheetItem.employee);           // deep copy
        project = anotherTimeSheetItem.project;
        from = anotherTimeSheetItem.from;
        to = anotherTimeSheetItem.to;
    }

     */

    public static TimeSheetItem withDifferentDay(TimeSheetItem timeSheetItem, LocalDate localDate) {
        TimeSheetItem copyTimeSheetItem = new TimeSheetItem(timeSheetItem);                        // copy konstrukrorral másolat példányosítása
        copyTimeSheetItem.from = LocalDateTime.of(localDate, copyTimeSheetItem.from.toLocalTime());// másolat from attr-nak átállítása
        copyTimeSheetItem.to = LocalDateTime.of(localDate, copyTimeSheetItem.to.toLocalTime());
        // from és to attr-ban szereplő dátumokat kicseréli a másodikként megadott napra, de az időket érintetlenül hagyja.
        // toLocalTime(): Gets the LocalTime part of this date-time. This returns a LocalTime with the same hour, minute.. as this date-time.
        return copyTimeSheetItem;
    }

//    public Employee getEmployee() {
//        return employee;
//    }


    public String getEmployee() {
        return employee;
    }

    public String getProject() {
        return project;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public LocalDateTime getTo() {
        return to;
    }

}
