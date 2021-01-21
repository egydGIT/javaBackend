package iowriter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class NameWriter {

    private Path file;

    public NameWriter(String filePath) {
        this.file = Path.of(filePath);

    }

   public void addAndWrite(String name) {
       try (BufferedWriter bw = Files.newBufferedWriter(this.file, StandardOpenOption.APPEND)) {
           bw.write(name + "\n");
       } catch (IOException e) {
           throw new IllegalArgumentException("Invalid filename: " + file, e);
       }

   }


    public static void main(String[] args) {
        NameWriter nameWriter = new NameWriter("namewriter.txt");
        nameWriter.addAndWrite("Szabó Attila");
        nameWriter.addAndWrite("Tamássdi Erik");

    }
}
