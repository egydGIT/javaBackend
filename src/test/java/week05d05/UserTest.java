package week05d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {

    @Test
    void testCreateUser() {
        assertThrows(IllegalArgumentException.class, ()
                -> new User("John", "Doe", "john.doe*gmail.com"));
    }

    @Test
    void testGetFullName() {
        assertEquals("John Doe",
                new User("John", "Doe", "john.doe@gmail.com").getFullName());
    }

    @Test
    void testGetters() {
        assertEquals("john.doe@gmail.com",
                new User("John", "Doe", "john.doe@gmail.com").getEmail());

        assertEquals("John",
                new User("John", "Doe", "john.doe@gmail.com").getFirstName());
    }
}
