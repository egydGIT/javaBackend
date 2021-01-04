package week06d05;

import introinheritance.personemployeeboss.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BiscuitTest {

    @Test
    void testOf() {
        assertEquals(BiscuitType.HIT, new Biscuit().of(BiscuitType.HIT, 150).getType());
    }

}
