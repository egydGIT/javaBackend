package week08d02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LotteryTest {

    @Test
    void testGetNumber() {
        Lottery lottery = new Lottery();
        assertEquals(Arrays.asList(58, 25, 29, 65, 12), lottery.getNumber());     // seed: 77
    }
}
