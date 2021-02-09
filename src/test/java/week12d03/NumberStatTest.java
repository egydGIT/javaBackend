package week12d03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberStatTest {

    @Test
    void testReadFromFile() {
        NumberStat ns = new NumberStat();
        ns.readFromFile("numberstat.txt");
        assertEquals(Arrays.asList(1, 1, 4, 2, 3, 5, 2, 2, 5), ns.getNumbers());
    }

    @Test
    void testFindSmallestUnique() {
        NumberStat ns = new NumberStat();
        ns.readFromFile("numberstat.txt");
        List<Integer> numbers = ns.getNumbers();
        // ??
    }

}