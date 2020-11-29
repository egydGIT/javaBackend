package stringbasic.pet;

import java.time.LocalDate;

public class Pet {
    private String name;
    private String yearOfBirth;
    private Gender GENDER;
    private String regNumber;

    public Pet(String name, String yearOfBirth, Gender GENDER, String regNumber) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.GENDER = GENDER;
        this.regNumber = regNumber;
    }

    public String getName() {
        return name;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public Gender getGENDER() {
        return GENDER;
    }

    public String getRegNumber() {
        return regNumber;
    }
}
