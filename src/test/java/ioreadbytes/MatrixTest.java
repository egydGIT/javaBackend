package ioreadbytes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatrixTest {

    Matrix matrix = new Matrix();

    @Test
    public void readBytesAndCreateMatrixTest() {
        assertEquals(0, matrix.getMatrix().size());
        matrix.readMatrixData("src/main/resources/matrix.dat");

        assertEquals(9, matrix.getMatrix().size());
        assertEquals(1000, matrix.getMatrix().get(5).length);
    }

    @Test
    public void numberOfColumnsWhereMoreZeros() {
        matrix.readMatrixData("src/main/resources/matrix.dat");
        assertEquals(493, matrix.numberOfColumnsWhereMoreZeros());
    }

}