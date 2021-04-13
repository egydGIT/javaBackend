package statemachine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CapsLockTest {

    @Test
    void testCapsLock() {
        assertEquals(CapsLock.LOWER_CASE, CapsLock.UPPER_CASE.next());
    }

    @Test
    public void testNext() {

        assertEquals(CapsLock.UPPER_CASE, CapsLock.LOWER_CASE.next());
        assertEquals(CapsLock.LOWER_CASE, CapsLock.UPPER_CASE.next());
    }
}