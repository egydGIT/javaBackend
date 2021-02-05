package collectionsiterator;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LibraryManager {

    private Set<Book> libraryBooks;

    public LibraryManager(Set<Book> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public Book findBookByRegNumber(int regNumber) {
        Book find = null;
        Iterator<Book> iterator = libraryBooks.iterator();
        while (iterator.hasNext()) {
            find = iterator.next();
            if(find.getRegNumber() == regNumber) {
                return find;
            }
        }
        throw new MissingBookException("Can not find book with regnumber: " + regNumber);
    }

    public int removeBookByRegNumber(int regNumber) {
        Book find = null;
        Iterator<Book> iterator = libraryBooks.iterator();
        while (iterator.hasNext()) {
            find = iterator.next();
            if(find.getRegNumber() == regNumber) {
                iterator.remove();
                return find.getRegNumber();
            }
        }
        throw new MissingBookException("Can not find book with regnumber: " + regNumber);
    }

    public Set<Book> selectBooksByAuthor(String author) {
        Set<Book> foundBooksWithSameAuthor = new HashSet<>();
        Book find = null;
        Iterator<Book> iterator = libraryBooks.iterator();

        while (iterator.hasNext()) {
            find = iterator.next();
            if (find.getAuthor().equals(author)) {
                foundBooksWithSameAuthor.add(find);
            }
        }

        if (foundBooksWithSameAuthor.isEmpty()) {
            throw new MissingBookException("With " + author + " there's no book found.");
        }
        return foundBooksWithSameAuthor;
    }

    public int libraryBooksCount() {
        return libraryBooks.size();
    }

    public Set<Book> getLibraryBooks() {
        return libraryBooks;
    }



    public static void main(String[] args) {

        Set<Book> libraryBooks = new HashSet<>();
        libraryBooks.add(new Book(123, "Title1", "Author1"));
        libraryBooks.add(new Book(456, "Title2", "Author2"));
        libraryBooks.add(new Book(789, "Title3", "Author1"));

        LibraryManager lm = new LibraryManager(libraryBooks);

        System.out.println(libraryBooks);

        System.out.println(lm.findBookByRegNumber(123));

        System.out.println(lm.removeBookByRegNumber(456));
        System.out.println(lm.getLibraryBooks());

        System.out.println(lm.selectBooksByAuthor("Author1"));

    }
}
