package stringconcat.employee;

public class Employee {
    private String name;

    private String profession;

    private int salary;

    public Employee(String name, String profession, int salary) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Name must not be empty.");
        }
        if (isEmpty(profession)) {
            throw new IllegalArgumentException("Job must not be empty.");
        }
        if (salary <= 0 ) {                                                         // && (salary % 1000 != 0)
            throw new IllegalArgumentException("Salary must be positive.");         // and divisible with 1000
        }
        this.name = name;
        this.profession = profession;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getProfession() {
        return profession;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + " - " + profession + " - " + salary + " Ft";
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
