package week04d02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchTutorialTest {

    @Test
    public void testGetPositionOfChar() {                               // Ezt én írtam, nem Tutorial
        SearchTutorial searchTutorial = new SearchTutorial();
        List<Integer> search
                = searchTutorial.getPositionOfChar("getPositionOfChar", "posiTion");
        assertEquals(Arrays.asList(3), search);
    }
}
