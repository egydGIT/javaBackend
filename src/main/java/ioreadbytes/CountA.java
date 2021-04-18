package ioreadbytes;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class CountA {

    public int countA(String fileName) {
        Path file = Path.of(fileName);
        int sumOfA = 0;
        try (InputStream inputStream = Files.newInputStream(file)) {
            byte[] bytes = new byte[1000];
            int size;
            while ((size = inputStream.read(bytes)) > 0) {
                for (int i = 0; i < size; i++) {
                    if (bytes[i] == (byte)'a') {
                        sumOfA++;
                    }
                }
            }
        }catch (IOException e) {
            throw new IllegalStateException("Cant find file. ", e);
        }
        return sumOfA;
    }
}
