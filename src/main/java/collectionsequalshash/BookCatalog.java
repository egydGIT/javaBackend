package collectionsequalshash;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookCatalog {

    private Book book;

    public BookCatalog() {
    }

    public BookCatalog(Book book) {
        this.book = book;
    }

    public Book findBookByTitleAuthor(List<Book> books, String title, String author) {
        Book find = null;
        for (Book b: books) {
            if (b.getAuthor().equals(author) && b.getTitle().equals(title)) {
                find = b;
            }
        }
        return find;
    }

    public Book findBook(List<Book> books, Book book) {
        Book find = null;
        for (Book b: books) {
            if (b.equals(book)) {
                find = b;
            }
        }
        return find;
    }

    public Set<Book> addBooksToSet(Book[] books) {
        Set<Book> allBooks = new HashSet<>();
        for (Book b: books) {
            allBooks.add(b);
        }
        return allBooks;
    }

    public Book getBook() {
        return book;
    }
}
