package stringbasic;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PoolHeapTest {

    @Test
    public void sameStringsInPoolShouldBeTheSameObject2() {
        //Given
        PoolHeap sc = new PoolHeap();

        //Then
        assertTrue(sc.createStringForPool2() == sc.createStringForPool2());
        assertFalse(sc.createStringForHeap2() == sc.createStringForHeap2());
        assertTrue(sc.createStringForPool2().equals(sc.createStringForHeap2()));
    }

    @Test
    public void sameStringsShouldBeTheSameByCanonicalRepresentation2() {
        //Given
        PoolHeap sc = new PoolHeap();

        //Then
        assertTrue(sc.createStringForHeap2().intern() == sc.createStringForHeap2().intern());
        assertTrue(sc.createStringForHeap2().intern() == sc.createStringForPool2().intern());
    }
}