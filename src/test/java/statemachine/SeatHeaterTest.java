package statemachine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeatHeaterTest {

    @Test
    void testSeatHeater() {
        assertEquals(SeatHeater.STATE_THREE, SeatHeater.TURN_OFF.nxt());
        assertEquals(SeatHeater.STATE_TWO, SeatHeater.STATE_THREE.nxt());

    }

}