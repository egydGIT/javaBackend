package week06d01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ListSelectorTest {

    @Test
    void testListSelector() {
        ListSelector listSelector = new ListSelector();
        List<String> words = Arrays.asList("első", "második", "harmadik", "negyedik", "ötödik");
        assertEquals(Arrays.asList("első", "harmadik", "ötödik"), listSelector.listSelector(words));
    }

    /*
    @Test
    void testIae() {
        List<String> wordsEmpty = Arrays.asList(null);
        assertThrows(NullPointerException.class, () -> new ListSelector().listSelector(wordsEmpty));
    }

     */
}
