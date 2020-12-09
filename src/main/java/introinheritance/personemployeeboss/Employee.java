package introinheritance.personemployeeboss;

public class Employee extends Person{
    private double salary;

    public Employee(String name, String address, double salary) {
        super(name, address);
        this.salary = salary;
    }

    public double getSalaryEmployee() {
        return salary;
    }

    public double getSalary() {
        return salary;
    }

    public double raiseSalary(int percent) {
        this.salary *= 1 + (percent / 100.0);       // this.salary += this.salary * (1.0 * percent / 100);
        return salary;
    }
}
