package week12d05;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class CovidTest {

    @Test
    void testWordCounter() {
        Covid c = new Covid();
        Path file = Path.of("src/main/resources/index.html");
        int counter = c.wordCounter("covid", file);
        assertEquals(4, counter);
    }

    @Test
    void testWordCounterWihtSimpleFile() {
        Covid c = new Covid();
        Path file = Path.of("src/main/resources/testdata.txt");
        int counter = c.wordCounter("semmi", file);
        assertEquals(2, counter);
    }

}