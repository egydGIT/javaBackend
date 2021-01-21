package ioreadwritebytes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemperatureReader {

    public Temperatures readTemperatures(String filePath) {
        Path file = Path.of(filePath);
        try {
            byte[] bytes = Files.readAllBytes(file);                            // byte-ok beolvasása file-ból
            return new Temperatures(bytes);
        } catch (IOException e) {
            throw new IllegalArgumentException("Cant find file." + e);
        }
    }

}
