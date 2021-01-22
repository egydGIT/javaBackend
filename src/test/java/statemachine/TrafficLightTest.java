package statemachine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrafficLightTest {

    @Test
    void testTrafficLight() {
        assertEquals(TrafficLight.GREEN, TrafficLight.RED_YELLOW.next());
    }

}