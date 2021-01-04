package week07d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DigitSumTest {

    @Test
    void testSumOfDigits() {
        assertEquals(6, new DigitSum().sumOfDigits(123));
        assertEquals(9, new DigitSum().sumOfDigits(333));
        assertEquals(7, new DigitSum().sumOfDigits(502));
    }
}
