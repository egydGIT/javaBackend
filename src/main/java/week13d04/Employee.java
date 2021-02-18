package week13d04;

public class Employee {

    private String name;                //  {nev}  helyére
    private int yearOfBirth;            //  {ev}

    public Employee(String name, int yearOfBirth) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
}
