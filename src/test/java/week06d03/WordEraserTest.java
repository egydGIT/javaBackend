package week06d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordEraserTest {

    @Test
    void testEraseWord() {
        assertEquals("A java tanulás jó! ",
                new WordEraser().eraseWord("A kva java tanulás kva jó!", "kva"));
    }
}
