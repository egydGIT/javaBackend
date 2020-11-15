package objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectsMain {
    public static void main(String[] args) {

        new Book();                     // Nem lehet hozzáférni. Néven keresztül hivatkozunk.

        Book book = new Book();
        System.out.println(book);               // objects.Book@378bf509
        System.out.println(book.toString());    // objects.Book@378bf509

        Book emptyBook = new Book();
        emptyBook = null;
        System.out.println(emptyBook);

        System.out.println(emptyBook == null);

        if (emptyBook == null) {
            System.out.println("ememptyBook is null");
        } else {
            System.out.println("ememptyBook isn't null");
        }

        Book book2 = new Book();
        System.out.println(book2);              // objects.Book@5fd0d5ae
        book2 = null;
        System.out.println(book2);
        book2 = new Book();
        System.out.println(book2);              // objects.Book@2d98a335

        Book anotherBook = new Book();
        System.out.println(book2 == anotherBook);  // false - más a referenci címük

        anotherBook = book2;
        System.out.println(book2);                  // objects.Book@2d98a335
        System.out.println(anotherBook);            // objects.Book@2d98a335
        System.out.println(anotherBook == book2);   // true

        System.out.println(anotherBook instanceof Book);    // true

        Book[] books = {new Book(), new Book(), new Book()};

        List<Book> bookList = Arrays.asList(new Book(), new Book(), new Book());

        List<Book> bookList2 = new ArrayList<>();
        bookList2.add(new Book());
        bookList2.add(new Book());
        bookList2.add(new Book());




    }
}
