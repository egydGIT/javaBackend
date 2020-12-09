package introinheritance.personemployeeboss;

public class Boss extends Employee {
    private static final double LEADERSHIP_FACTOR = 0.1;
    private int numberOfEmployees;

    public Boss(String name, String address, double salary, int numberOfEmployees) {
        super(name, address, salary);
        this.numberOfEmployees = numberOfEmployees;
    }

    public double getSalaryBoss() {                                 // Salary 1.
        return super.getSalaryEmployee() + super.getSalaryEmployee() * getNumberOfEmployees() * LEADERSHIP_FACTOR;
    }

    public double getSalary() {                                     // Salary 2.
        return super.getSalary() + super.getSalary() * getNumberOfEmployees() * LEADERSHIP_FACTOR;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public static double getLeadershipFactor() {
        return LEADERSHIP_FACTOR;
    }

}
