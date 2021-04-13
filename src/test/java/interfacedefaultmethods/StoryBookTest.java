package interfacedefaultmethods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoryBookTest {

    @Test
    public void testCreateAndAddPage() {
        StoryBook storyBook = new StoryBook();

        assertEquals(0, storyBook.getLength());

        storyBook.addPage("Page1", Printable.DEFAULT_COLOUR_BLACK);
        storyBook.addPage("Page2", "#FF0000");
        assertEquals(2, storyBook.getLength());
        assertEquals("Page1", storyBook.getPage(0));
        assertEquals(Printable.DEFAULT_COLOUR_BLACK, storyBook.getColor(0));
        assertEquals("Page2", storyBook.getPage(1));
        assertEquals("#FF0000", storyBook.getColor(1));
    }
}