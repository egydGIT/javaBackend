package week05d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChangeLetterTest {

    @Test
    void testChangeVowels() {
        ChangeLetter changeLetter = new ChangeLetter();
        assertEquals("*ppl*", changeLetter.changeVowels("apple"));
        assertEquals("c*l*mb*s", changeLetter.changeVowels("colombus"));
    }
}
