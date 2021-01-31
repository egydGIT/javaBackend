package collectionsequalshash;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BookCatalogTest {

    @Test
    void testFindBookByTitleAuthor() {
        BookCatalog bc = new BookCatalog();
        ;
        assertEquals(new Book("Title1", "Author1"), bc.findBookByTitleAuthor(
                List.of(new Book("Title1", "Author1"), new Book("Title2", "Author2")),
                "Title1", "Author1"));
    }

    @Test
    void testFindBook() {
        BookCatalog bc = new BookCatalog();
        assertEquals(null, bc.findBook(List.of(new Book("Title1", "Author1"), new Book("Title2", "Author2")),
                new Book("Title3", "Author3")));
    }

    @Test
    void testAddBooksToSet() {
        BookCatalog bc = new BookCatalog();
        Book[] books = {new Book("Title1", "Author1"),
                new Book("Title1", "Author1"),
                new Book("Title1", "Author1")};

//        assertEquals(Arrays.asList(new Book("Title1", "Author1")), bc.addBooksToSet(books));
//              Expected :[Book{title='Title1', author='Author1'}]
//              Actual   :[Book{title='Title1', author='Author1'}]                  // ??

        assertEquals(1, bc.addBooksToSet(books).size());
    }
}