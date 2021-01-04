package week04d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NameChangerTest {
    @Test
    void getFullNameTest() {
        assertEquals("Kölcsey Ferenc", new NameChanger("Kölcsey", "Ferenc").getFullName());
    }

    // Met-on belül Scanner, ezért nem tudom tesztelni
    /*
    @Test
    void changeFirstNameTest() {
        NameChanger nameChanger = new NameChanger("Kölcsey", "Ferenc");
        String newFirstName = "Kazinczy";
        assertEquals("Kazinczy Ferenc", nameChanger.changeFirstName());
    }
    */

    @Test
    public void testIae() {
        NameChanger nameChanger = new NameChanger("John", "Doe");
        assertEquals("John Doe", nameChanger.getFullName());

        assertThrows(IllegalArgumentException.class, () -> new NameChangerTutorial(""));
    }

    @Test
    public void testIaeMessage() {
        NameChanger nameChanger = new NameChanger("John", "Doe");
        assertEquals("John Doe", nameChanger.getFullName());

        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, ()
                -> new NameChangerTutorial(""));
        assertEquals("Invalid name", iae.getMessage());
    }

}
