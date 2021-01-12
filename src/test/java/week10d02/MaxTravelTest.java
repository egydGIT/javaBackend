package week10d02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MaxTravelTest {

    @Test
    void getMaxIndex() {
        assertEquals(9, new MaxTravel().getMaxIndex(Arrays.asList(5, 7,7,7, 8, 9,9,9,9,9, 10, 11,11)));
        assertEquals(2, new MaxTravel().getMaxIndex(Arrays.asList(1, 2,2, 3,3, 6, 7, 9)));
    }

}