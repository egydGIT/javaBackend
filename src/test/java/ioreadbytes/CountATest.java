package ioreadbytes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountATest {

    CountA countA = new CountA();

    @Test
    public void readBytesAndFindAsTest() {
        assertEquals(116, countA.countA("src/test/resources/data.dat"));
    }

}