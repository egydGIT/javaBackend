package week11d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisorFinderTest {

    @Test
    void testFindDivisors() {
        DivisorFinder df = new DivisorFinder();
        assertEquals(1, df.findDivisors(425));
        assertEquals(3, df.findDivisors(555));
        assertEquals(3, df.findDivisors(424));

    }



}