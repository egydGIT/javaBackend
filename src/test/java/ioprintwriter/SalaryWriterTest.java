package ioprintwriter;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SalaryWriterTest {

    @Test
    void testWriteNamesAndSalaries() {
        SalaryWriter sw = new SalaryWriter(List.of("Dr John Doe", "Mrs Jane Doe", "Jack"));
        Path file = Path.of("salarywriter2.txt");

        sw.writeNamesAndSalaries(Path.of("salarywriter2.txt"));

        List<String> fromFileToList = null;
        try {
            fromFileToList = Files.readAllLines(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals("Dr John Doe : 500000", fromFileToList.get(0));
        assertEquals(3, fromFileToList.size());


    }
}