package genericsusage;

import genericsusage.Book;

import java.util.List;

public class Library {

    public Book getFirstBookWithGenerics(List<Book> books) {
        if (books == null) {
            throw new NullPointerException("Argument should not be null!");
        }
        if (books.isEmpty()) {
            throw new IllegalArgumentException("Argument should not be empty!");
        }
        return books.get(0);
    }

    public Book getFirstBookWithOutGenerics(List books) {
        if (books == null) {
            throw new NullPointerException("Argument should not be null!");
        }
        if (books.isEmpty()) {
            throw new IllegalArgumentException("Argument should not be empty!");
        }
        Object o = books.get(0);
        if (!(o instanceof Book)) {
            throw new ClassCastException("Not a book");
        }
        return (Book) o;
    }

}