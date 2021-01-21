package iowriter;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NameWriterTest {

    @Test
    void testAddAndWrite() {
        NameWriter nameWriter = new NameWriter("namewriter.txt");
        nameWriter.addAndWrite("Kovács Emese");

        List<String> content = null;
        try {
            content = Files.readAllLines(Path.of("namewriter.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(List.of("Kovács Emese"), content);
        assertEquals(1, content.size());
    }

}