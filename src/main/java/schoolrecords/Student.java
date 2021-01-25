package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private List<Mark> marks = new ArrayList<>();                       // read only ?

    private String name;

    public Student(String name) {
        this.name = name;
    }

    public void grading(Mark mark) {
        // érdemjegy rögzítése

        marks.add(mark);
    }

/*
    public double calculateAverage(List<Mark> marks) {
        // teljes átlag számolása
        // az összes tantárgy összes érdemjegyének átlaga
    }

 */

    public double calculateSubjectAverage(Subject subject) {
        // tantárgyhoz tartozó átlag számítása

        int sum = 0;                                                    // összegzés algoritmumusa
        for (Mark mark : marks) {
            sum += mark.getMarkType().getValue();
        }
        return sum / marks.size();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
/*
    public boolean equals(Object) {
        // ??

        return true;
    }
 */
    private boolean isEmpty(String str) {
        // megvizsgálja, van-e üres v null értékű String paraméter

        if ("".equals(str) || str == null) {
            System.out.println("isEmpty");
        }
        return true;
    }

    @Override                                                // tesztesetekben a végleges formátum
    public String toString() {                               // diák szöveges reprezentációja
        return "Student{" +
                "marks=" + marks +
                ", name='" + name + '\'' +
                '}';
    }
}
