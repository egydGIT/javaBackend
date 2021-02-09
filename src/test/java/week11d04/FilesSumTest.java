package week11d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilesSumTest {

    @Test
    void testReadFile() {
        assertEquals(20, new FilesSum().readFile("number20.txt"));
        assertEquals(71, new FilesSum().readFile("number71.txt"));
    }

    @Test
    void testSumNumbers() {
        assertEquals(91, new FilesSum().sumNumbers());
    }

}