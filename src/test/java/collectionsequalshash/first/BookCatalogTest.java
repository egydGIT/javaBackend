package collectionsequalshash.first;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookCatalogTest {

    @Test
    void testFindBookByTitleAuthor() {
        BookCatalog bc = new BookCatalog();

        Assertions.assertEquals(new Book("Title1", "Author1"), bc.findBookByTitleAuthor(
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


    /*
    Szerintem, ha kikommentelem az equals() és hashCode() override-okat,
    akkor az Objects-ben deklarlt metódusokat fogja használni.
    Ami az objektiumokat referencia egyezőség szerint hasonlítja össze és nem a vizsgált attributumok alapján.

    public boolean equals(Object o) {
        return super.equals(o);
    }

    public int hashCode() {
        return super.hashCode();
    }

     */
}