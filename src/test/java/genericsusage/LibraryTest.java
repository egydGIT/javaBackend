package genericsusage;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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

    @Test
    void testGetFirstBookWithoutGenerics() {
        Object book1 = new Book("Title1", "Somebody", 1529763);
        Object book2 = new Book("Title2", "Somebody Else", 1458796);
        List booksWithoutGenerics = new ArrayList();
        booksWithoutGenerics.add(book1);
        booksWithoutGenerics.add(book2);
        booksWithoutGenerics.add("Just title");
        booksWithoutGenerics.add(1584616);

        Book bookWG = (Book) new Library().getFirstBookWithoutGenerics(booksWithoutGenerics);
        assertEquals("Title1", bookWG.getTitle());
        assertEquals(1529763, bookWG.getRegNumber());

        assertEquals(1584616, booksWithoutGenerics.get(3));
    }

}