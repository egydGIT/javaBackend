package week04d02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SearchMyTest {

    @Test
    public void testGetIndexesOfChar() {
        SearchMy search = new SearchMy();
        List<Integer> list = search.getIndexesOfChar("almafa", 'a');
        assertEquals(Arrays.asList(0, 3, 5), list);
    }

    @Test
    public void testGetMatchingChar() {
        SearchMy search = new SearchMy();
        List<Integer> list = search.getMatchingChar("almafa", 'a');
        assertEquals(Arrays.asList(0, -1, -1, 0, -1, 0), list);
    }

    @Test
    public void testIae() {
        assertThrows(IllegalArgumentException.class, () -> new SearchMy().getIndexesOfChar("", ' ') );
    }

    @Test
    public void testIaeMessage() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> new SearchMy().getIndexesOfChar("", ' ') );
        assertEquals("Invalid parameters!", iae.getMessage());
    }

    // Ezek a tesztek sztem már fölöslegesek (csak gyakorlás miatt)
    @Test
    public void testIae2() {
        assertThrows(IllegalArgumentException.class, () -> new SearchMy().getMatchingChar("", ' ') );
    }

    @Test
    public void testIaeMessage2() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> new SearchMy().getMatchingChar("", ' ') );
        assertEquals("Invalid parameters!", iae.getMessage());
    }

    @Test
    public void testIsEmpty() {
        assertEquals(true, new SearchMy().isEmpty(null, 'c'));
    }
}
