package searching;

import java.util.Arrays;

public class BookArraySearch {

    private Book[] bookArray;

    public BookArraySearch(Book[] bookArray) {
        this.bookArray = bookArray;
    }

    public Book findBookByAuthorTitle(String author, String title) {
        if (author.isEmpty() || title.isEmpty()) {
            throw new IllegalArgumentException("Searching parameters are missing. Author: " + author + " or Title: " + title);
        }
        // String[] searchParam = {author, title};
        Book searchBook = new Book(author, title);
        Arrays.sort(bookArray);
        int index = Arrays.binarySearch(bookArray, searchBook);
        if (index < 0) {
            throw new IllegalArgumentException("There's no matching book");
        }
        return bookArray[index];
    }

    public Book[] getBookArray() {
        return bookArray;
    }

    public void setBookArray(Book[] bookArray) {
        this.bookArray = bookArray;
    }
}
