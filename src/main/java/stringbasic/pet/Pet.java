package stringbasic.pet;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Pet {
    private String name;
    private LocalDate yearOfBirth;
    private Gender GENDER;
    private String regNumber;

    public Pet(String name, LocalDate yearOfBirth, Gender GENDER, String regNumber) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.GENDER = GENDER;
        this.regNumber = regNumber;
    }

    public String getName() {
        return name;
    }

    public LocalDate getYearOfBirth() {
        return yearOfBirth;
    }

    public Gender getGENDER() {
        return GENDER;
    }

    public String getRegNumber() {
        return regNumber;
    }
}
