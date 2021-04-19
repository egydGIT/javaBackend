package iodatastream.statistics;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class HeightStatistics {

    public void saveHeights(List<Integer> heights, Path file) {
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(file)))) {
            dos.writeInt(heights.size());
            for (Integer h : heights) {
                dos.writeInt(h);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cant write file.", e);
        }
    }
}
