package debug;

public class Employee {

    private String name;                                //  Attributum deklarációk
    private int yearOfBirth;

    public Employee(String name, int yearOfBirth) {     // Generált konstruktor
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {                           // Generált getter metódusok
        return name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
}
