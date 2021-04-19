package iowritebytes;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StringToBytes {

    private List<String> list = new ArrayList<>();

    public void writeAsBytes(List<String> list, Path path) {
        try (BufferedOutputStream bos = new BufferedOutputStream(Files.newOutputStream(path))) {
            for (String s : list) {
                if (!s.startsWith("_")) {
                    bos.write(s.getBytes());
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can not write file.", e);
        }
    }
}
