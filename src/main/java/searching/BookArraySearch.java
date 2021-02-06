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


    public static void main(String[] args) {

        Book[] bookArray = {new Book("Title1", "Author1"),
                            new Book("Title2", "Author2"),
                            new Book("Title3", "Author3"),
                            new Book("Title4", "Author4"),
                            new Book("Title5", "Author5")};
        BookArraySearch bas = new BookArraySearch(bookArray);
        System.out.println(bas.findBookByAuthorTitle("Title2", "Author2"));
        System.out.println(bas.findBookByAuthorTitle("", "Author8")); // Searching parameters are missing. Author:  or Title: Author8
        System.out.println(bas.findBookByAuthorTitle("Title8", "Author8"));  // There's no matching book

    }
}
