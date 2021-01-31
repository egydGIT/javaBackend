package collectionslist;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LotteryTest {

    @Test
    void testExceptions() {
        Lottery lottery = new Lottery();
        assertThrows(IllegalArgumentException.class, () -> lottery.selectWinningNumbers(7, 45));
        assertThrows(IllegalArgumentException.class, () -> lottery.selectWinningNumbers(5, 45));

    }

    @Test
    void testLottery() {
        Lottery lottery = new Lottery();
        assertEquals(Arrays.asList(11, 17, 43, 62, 65), lottery.selectWinningNumbers(5, 90));
        assertEquals(Arrays.asList(7, 11, 17, 20, 24, 43), lottery.selectWinningNumbers(6, 45));

    }

}