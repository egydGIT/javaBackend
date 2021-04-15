package ioreadstring.names;

import ioreadstring.names.FileManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileManagerTest {
    private FileManager fm = new FileManager("src/test/resources/names.txt");

    @Test
    public void createClassTest() {
        assertEquals("names.txt", fm.getFile().getFileName().toString());
        assertEquals(0, fm.getHumans().size());
    }


    @Test
    public void readFromFileTest() {
        fm.readFromFile();
        assertEquals(4, fm.getHumans().size());
        assertEquals("Anybody", fm.getHumans().get(1).getFirstName());
    }

}