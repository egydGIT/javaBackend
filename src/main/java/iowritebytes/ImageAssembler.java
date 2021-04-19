package iowritebytes;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImageAssembler {

    private byte[][] bytes;

    public void makeImageFile(byte[][] bytes, Path packageName) {
        Path path = packageName.resolve("image.png");
        try (BufferedOutputStream bos = new BufferedOutputStream(Files.newOutputStream(path))) {
            for (byte[] row : bytes) {
                bos.write(row);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can not write file.", e);
        }
    }
}
