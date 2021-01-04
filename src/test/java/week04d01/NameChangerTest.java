package week04d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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


}
