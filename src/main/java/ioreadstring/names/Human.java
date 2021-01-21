package ioreadstring.names;

public class Human {

    private String firsName;

    private String lastName;

    public Human(String firsName, String lastName) {
        this.firsName = firsName;
        this.lastName = lastName;
    }

    public String getFirsName() {
        return firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return firsName + " " + lastName;
    }
}
