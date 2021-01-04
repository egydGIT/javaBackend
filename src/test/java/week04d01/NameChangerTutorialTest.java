package week04d01;

import org.junit.jupiter.api.Test;
/*
import static org.junit.jupiter.api.AssertTrue.assertTrue;    // AssertTrue piros
 */
import static org.junit.jupiter.api.Assertions.*;

public class NameChangerTutorialTest {

    // public NameChanger

    @Test
    public void changeNameTest() {
        NameChangerTutorial nameChanger = new NameChangerTutorial("John Doe");
        nameChanger.changeFirstName("Jack");
        assertEquals("Jack Doe", nameChanger.getFullName());
    }

    @Test
    public void createNameChangerTest() {
        NameChangerTutorial nameChangerTutorial = new NameChangerTutorial("John Doe");
        assertEquals("John Doe", nameChangerTutorial.getFullName());

        assertThrows(IllegalArgumentException.class, () -> new NameChangerTutorial(""));
    }

    @Test
    public void createNameChangerTest2() {
        NameChangerTutorial nameChangerTutorial = new NameChangerTutorial("John Doe");
        assertEquals("John Doe", nameChangerTutorial.getFullName());

        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, ()
                -> new NameChangerTutorial(""));
        assertEquals("Invalid name", iae.getMessage());
    }

    // isTheSame()t nem tudom importálni ( pom.xml -t frissítettem 5.7.0-ra, de nem segít )
/*  @Test
    public void isTheSameTest() {
        NameChangerTutorial nameChangerTutorial = new NameChangerTutorial("John Doe");

        assertEquals(true, nameChangerTutorial.isTheSame("John Doe"));
        assertTrue(nameChangerTutorial.isTheSame("John Doe"));
        assertFalse(nameChangerTutorial.isTheSame("John Doe"));

    }
 */
}
