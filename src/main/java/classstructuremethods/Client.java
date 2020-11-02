package classstructuremethods;

public class Client {

    private String name;
    private int yearOfBirth;
    private String address;
    private String newAddress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public void changeAddress(String newAddress) {
        address = newAddress;
    }
}
