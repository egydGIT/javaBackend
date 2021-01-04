package week07d03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberListTest {

    @Test
    void testIsIncreasing() {
        assertTrue(new NumberList().isIncreasing(Arrays.asList(1, 2, 3, 7, 8, 12, 18, 20)));
        assertFalse(new NumberList().isIncreasing(Arrays.asList(8, 5, 3, 1)));
        assertFalse(new NumberList().isIncreasing(Arrays.asList(5, 2, 9, 7, 12)));
    }
}
