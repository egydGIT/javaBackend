package week05d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListCounterTest {

    @Test
    void testCountStartWithA() {
        ListCounter listCounter = new ListCounter();
        assertEquals(4, listCounter.countStartWithA("az alma érésének ideje az, amikor"));
        assertEquals(0, listCounter.countStartWithA("itt egy sem kezdődik"));

    }
}
