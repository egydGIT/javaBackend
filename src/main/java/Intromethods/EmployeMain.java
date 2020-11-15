package Intromethods;

public class EmployeMain {
    public static void main(String[] args) {
        Employee employee = new Employee("Urbán Enikő", 2015, 320000);

        System.out.println("Alkalmazott neve: " + employee.getName());
        System.out.println("Belépés éve: " + employee.getHiringYear());
        System.out.println("Fizetés: " + employee.getSalary());

        System.out.println("Módosítás: " + employee.setName("Dósa-Urbán Enikő"));
        System.out.println(employee.raiseSalary(55000));
    }
}
