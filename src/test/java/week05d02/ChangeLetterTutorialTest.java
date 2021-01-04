package week05d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChangeLetterTutorialTest {

    @Test
    void testChangeVowels() {
        assertEquals("c*l*mb*s", new ChangeLetterTutorial().changeVowels("colombus"));
    }
}
