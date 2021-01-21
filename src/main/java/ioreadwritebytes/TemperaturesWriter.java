package ioreadwritebytes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemperaturesWriter {

    public void writeTemperatures(Temperatures temperatures, String filePath) {
        Path file = Path.of(filePath);
        try {
            Files.write(file, temperatures.getData());                                  // byte-ok kiírása file-ba
        } catch (IOException e) {
            throw new IllegalArgumentException("Cant find file." + e);
        }
    }
}
