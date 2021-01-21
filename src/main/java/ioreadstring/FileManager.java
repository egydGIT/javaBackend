package ioreadstring;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private Path file;

    private List<Human> humans = new ArrayList<>();

    private String relativePath;

    public FileManager(String relativePath) {
        this.file = Path.of(relativePath);
    }

    public void readFromFile() {
        try {
            List<String> fileInStringLines = Files.readAllLines(file);
            for (String s : fileInStringLines) {
                String[] stringListParts = s.split(" ");
                String first = stringListParts[0];
                String second = stringListParts[1];
                Human h = new Human(first, second);
                humans.add(h);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Cant read file.", e);
        }
    }

    public Path getFile() {
        return file;
    }

    public List<Human> getHumans() {
        return humans;
    }



    public static void main(String[] args) {
        FileManager fm = new FileManager("names.txt");
        fm.readFromFile();
    }

}
