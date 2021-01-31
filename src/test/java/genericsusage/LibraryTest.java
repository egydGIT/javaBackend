package genericsusage;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test
    void testGetFirstBook() {
        Library library = new Library();
        Book libraryBook = library.getFirstBook(List.of(new Book("Title1", "Somebody", 1529763),
                new Book("Title2", "Somebody Else", 1458796)));

        assertEquals(1529763, libraryBook.getRegNumber());
        assertEquals("Somebody", libraryBook.getAuthor());

    }

    @Test
    void testIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Library().getFirstBook(List.of()));
    }

    @Test
    void testNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Library().getFirstBook(null));
    }

}