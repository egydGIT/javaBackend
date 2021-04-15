package iowritestring.scool;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiaryTest {

    @TempDir
    public Path temporaryFolder;

    private Diary diary = new Diary();

//    @Test
//    void testNewMarkMy() throws IOException {
//
//        diary.newMarkMy("tanulo_neve", 5);
//        diary.newMarkMy("tanulo_neve", 3);
//
//        List<String> testList = null;
//        try {
//            testList = Files.readAllLines(Path.of("tanulo_neve.txt"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        assertEquals(2, testList.size());
//        assertEquals("3", testList.get(1));
//
//        diary.average(Path.of("tanulo_neve.txt"));
//
//    }

    @Test
    public void newMarkTestIfNotExists() throws IOException {
        Path file = Files.createFile(temporaryFolder.resolve("test.txt"));
        diary.newMark(file, 5);
        List<String> testList = Files.readAllLines(file);

        assertEquals(1, testList.size());
        assertEquals("5", testList.get(0));
    }

    @Test
    public void newMarkTestIfExists() throws IOException {
        Path file = Files.createFile(temporaryFolder.resolve("test.txt"));
        diary.newMark(file, 4);
        diary.newMark(file, 2);


        diary.newMark(file, 3);
        List<String> testList = Files.readAllLines(file);

        assertEquals(3, testList.size());
    }

    @Test
    public void averageTest() throws IOException {
        Path file = Files.createFile(temporaryFolder.resolve("test.txt"));
        Files.writeString(file, "5\n");
        Files.writeString(file, "3\n", StandardOpenOption.APPEND);
        Files.writeString(file, "4\n", StandardOpenOption.APPEND);

        diary.average(file);

        List<String> avgTestList = Files.readAllLines(file);
        assertEquals(4, avgTestList.size());
        assertEquals("Average: 4.0", avgTestList.get(avgTestList.size() - 1));

    }


}