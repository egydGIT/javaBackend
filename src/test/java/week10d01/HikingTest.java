package week10d01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HikingTest {

    @Test
    void getPlusElevation() {
        assertEquals(35.0, new Hiking().getPlusElevation(Arrays.asList(15.0, 20.0, 35.0, 50.0)));
        assertEquals(13.0, new Hiking().getPlusElevation(Arrays.asList(10.0, 20.0, 15.0, 18.0)));
        assertEquals(0.0, new Hiking().getPlusElevation(Arrays.asList(12.0, 12.0, 12.0, 12.0)));
        assertEquals(0.0, new Hiking().getPlusElevation(Arrays.asList(75.0, 60.0, 32.0, 20.0)));
    }

}