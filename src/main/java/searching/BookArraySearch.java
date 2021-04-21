package searching;

import java.util.Arrays;

public class BookArraySearch {

    private Book[] bookArray;

    public BookArraySearch(Book[] bookArray) {
        this.bookArray = bookArray;
    }

    public Book findBookByAuthorTitle(String author, String title) {
        if (isEmpty(author) || isEmpty(title)) {
            // throw new IllegalArgumentException("Searching parameters are missing. Author: " + author + " or Title: " + title);
            throw new IllegalArgumentException("Author or title must not be empty!");
        }
        Book searchBook = new Book(author, title);                  // paraméterek alapján új Book obj. példányosítás
        Arrays.sort(bookArray);                                     // keresés csak rendezett listán működik -> sort
        int index = Arrays.binarySearch(bookArray, searchBook);     // bináris keresés natural ordering alapján
                                                                    // mert Comparable if-t Book oszt. implementáljaja
                                                                    // compareTo met. talált elem indexével tér vissza
        if (index < 0) {                                            // és negatív értékkel, ha nincs egyezés
            // throw new IllegalArgumentException("There's no matching book");
            throw new IllegalArgumentException("No book found by " + author + " with title " + title);
        }
        return bookArray[index];               // met. a tömb azon indexen lévő elemével tér vissza, amit keresés adott
    }

    public Book[] getBookArray() {
        return bookArray;
    }

    public void setBookArray(Book[] bookArray) {
        this.bookArray = bookArray;
    }

    private boolean isEmpty(String str){
        return str == null || "".equals(str.trim());
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
