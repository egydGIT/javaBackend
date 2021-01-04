package week07d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathAlgorithmsTest {

    @Test
    void testIsPrime() {
        assertEquals(false, new MathAlgorithms().isPrime(1));
        assertEquals(true, new MathAlgorithms().isPrime(2));
        assertEquals(false, new MathAlgorithms().isPrime(4));
        assertEquals(true, new MathAlgorithms().isPrime(5));
        assertEquals(true, new MathAlgorithms().isPrime(7));
        assertEquals(true, new MathAlgorithms().isPrime(11));
        assertEquals(false, new MathAlgorithms().isPrime(12));
    }
}
