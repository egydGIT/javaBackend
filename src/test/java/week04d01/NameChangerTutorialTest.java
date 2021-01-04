package week04d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NameChangerTutorialTest {

    // public NameChanger

    @Test
    public void changeNameTest() {
        NameChangerTutorial nameChanger = new NameChangerTutorial("John Doe");
        nameChanger.changeFirstName("Jack");
        assertEquals("Jack Doe", nameChanger.getFullName());
    }
}
