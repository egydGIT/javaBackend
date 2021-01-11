package week08d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CanMarkTest {

    @Test
    void giveMarkTest() {
        assertEquals(3, new Trainer(new BadMood()).giveMark());
        assertEquals(5, new Trainer(new GoodMood()).giveMark());
    }
}
