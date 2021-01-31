package genericsusage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Library {

    private List<Book> books = new ArrayList<>();

    private List booksWithoutGenerics = new ArrayList();

    public Library() {
    }

    public Book getFirstBook(List<Book> books) {
        if (books == null) {
            throw new NullPointerException("Book list is null.");
        }
        if (books.isEmpty()) {
            throw new IllegalArgumentException("Book list is empty.");
        }
        Book b = null;
        for (int i = 0; i < books.size(); i++) {
            b = books.get(0);
        }
        return b;
    }

    public Object getFirstBookWithoutGenerics(List booksWithoutGenerics) {   // ?
        if (booksWithoutGenerics == null) {
            throw new NullPointerException("Book list is null.");
        }
        if (booksWithoutGenerics.isEmpty()) {
            throw new IllegalArgumentException("Book list is empty.");
        }
        Object b = null;
        for (int i = 0; i < booksWithoutGenerics.size(); i++) {
            b = (Object) booksWithoutGenerics.get(0);
        }
        return b;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List getBooksWithoutGenerics() {
        return booksWithoutGenerics;
    }


    public static void main(String[] args) {
        Library library = new Library();
        System.out.println(library.getFirstBook(List.of(new Book("Title1", "Somebody", 1529763),
                new Book("Title2", "Somebody Else", 1458796))).getTitle());       // Title1


//        Library library1 = new Library();
//        System.out.println(library1.getFirstBook(List.of()));                 // java.lang.IllegalArgumentException: Book list is empty.

//        Library library2 = new Library();
//        System.out.println(library2.getFirstBook(Collections.EMPTY_LIST));    // java.lang.IllegalArgumentException: Book list is empty.

//        Library library3 = new Library();
//        System.out.println(library3.getFirstBook(null));                      // java.lang.NullPointerException: Book list is null.

        Object book1 = new Book("Title1", "Somebody", 1529763);
        Object book2 = new Book("Title2", "Somebody Else", 1458796);
        List booksWithoutGenerics = new ArrayList();
        booksWithoutGenerics.add(book1);
        booksWithoutGenerics.add(book2);
        booksWithoutGenerics.add("Just title");
        booksWithoutGenerics.add(1584616);
        System.out.println(booksWithoutGenerics.toString());
        // [Book{title='Title1', author='Somebody', regNumber=1529763}, Book{title='Title2', author='Somebody Else', regNumber=1458796}, Just title, 1584616]

        System.out.println(library.getFirstBookWithoutGenerics(booksWithoutGenerics).toString());
        // Book{title='Title1', author='Somebody', regNumber=1529763}

        Book bookWG = (Book) library.getFirstBookWithoutGenerics(booksWithoutGenerics);
        System.out.println(bookWG.getTitle());                                              // Title1

    }
}
