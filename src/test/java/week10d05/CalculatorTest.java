package week10d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testFindMinSum() {
        assertEquals(17, new Calculator().findMinSum(new int[]{5, 10, 7, 2, 3, 8}));
        assertEquals(14, new Calculator().findMinSum(new int[]{4, 5, 2, 4, 4}));
    }

}