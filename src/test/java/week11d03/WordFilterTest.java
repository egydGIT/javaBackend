package week11d03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class WordFilterTest {

    @Test
    void testWordsWithChar() {
        assertEquals(Arrays.asList("dog", "mouse"), new WordFilter().wordsWithChar(Arrays.asList("cat", "dog", "mouse"), 'o'));
        assertEquals(Arrays.asList("one", "three"), new WordFilter().wordsWithChar(Arrays.asList("one", "two", "three"), 'e'));
    }

}