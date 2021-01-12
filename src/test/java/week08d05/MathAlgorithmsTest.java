package week08d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathAlgorithmsTest {

    @Test
    void testGreatestCommonDivisor() {
        assertEquals(9, new MathAlgorithms().greatestCommonDivisor(18, 9));
        assertEquals(8, new MathAlgorithms().greatestCommonDivisor(24, 16));
    }
}
