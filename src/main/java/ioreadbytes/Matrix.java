package ioreadbytes;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Matrix {

    private List<byte[]> matrix = new ArrayList<>();

    public void readMatrixData(String fileName) {
        Path file = Path.of(fileName);
        byte[] buffer = new byte[1000];
        try (InputStream is = new BufferedInputStream(Files.newInputStream(file))){
            int size;
            while ((size = is.read(buffer)) > 0) {
                matrix.add(buffer);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can not read file.", e);
        }
    }

    public int numberOfColumnsWhereMoreZeros() {            // solution
        int numOfColumns = 0;
        for (int i = 0; i < 1000; i++) {
            int zeros = 0;
            int ones = 0;
            for (int j = 0; j < matrix.size(); j++) {
                if (matrix.get(j)[i] == 48) {
                    zeros++;
                } else {
                    ones++;
                }
            }
            if (zeros > ones) {
                numOfColumns++;
            }
        }
        return numOfColumns;
    }

    public List<byte[]> getMatrix() {
        return matrix;
    }
}
