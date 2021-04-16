package ioprintwriter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SalaryWriterTest {

    @Test
    void testWriteNamesAndSalaries() {
        SalaryWriter sw = new SalaryWriter(List.of("Dr John Doe", "Mrs Jane Doe", "Jack"));
        Path file = Path.of("src/test/resources/salarywriter2.txt");

        sw.writeNamesAndSalaries(Path.of("src/test/resources/salarywriter2.txt"));

        List<String> fromFileToList = null;
        try {
            fromFileToList = Files.readAllLines(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals("Dr John Doe: 500000", fromFileToList.get(0));
        assertEquals(3, fromFileToList.size());


    }

    @TempDir
    public File folder;

    private SalaryWriter sw = new SalaryWriter(List.of("Dr. John Doe", "Mrs. Jane Doe", "Dr. Julie Smith", "Jack Doe"));

    @Test
    public void testWriteNamesAndSalaries2() throws IOException {
        Path file = new File(folder, "test.txt").toPath();
        sw.writeNamesAndSalaries(file);
        List<String> writtenLines = Files.readAllLines(file);


        assertEquals("Dr. Julie Smith: 500000", writtenLines.get(2));
        assertEquals("Mrs. Jane Doe: 200000", writtenLines.get(1));
        assertEquals("Jack Doe: 100000", writtenLines.get(3));
    }
}