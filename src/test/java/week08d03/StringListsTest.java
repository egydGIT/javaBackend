package week08d03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringListsTest {

    @Test
    void testStringListsUnion() {
        List<String> firstActualParam = Arrays.asList("egy", "kettő", "három");
        List<String> secondActualParam = Arrays.asList("három", "négy", "öt");

        assertEquals(Arrays.asList("egy", "kettő", "három", "négy", "öt"),
                new StringLists().stringListsUnion(firstActualParam, secondActualParam) );
    }
}
