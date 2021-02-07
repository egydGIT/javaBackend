package sorting;

import java.util.Arrays;
import java.util.Comparator;

public class OrderedArrayLibrary {

    private Book[] bookArray;

    public OrderedArrayLibrary(Book[] bookArray) {
        this.bookArray = bookArray;
    }

    public Book[] sortingById() {
        Book[] bookArrayCopy = Arrays.copyOf(bookArray, bookArray.length);
        Arrays.sort(bookArrayCopy);
        return bookArrayCopy;
    }

    public Book[] sortingByTitle() {
        Book[] bookArrayCopy = Arrays.copyOf(bookArray, bookArray.length);
        Arrays.sort(bookArrayCopy, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
        return bookArrayCopy;
    }


    public static void main(String[] args) {
        Book[] bookArray = {new Book(1, "B_Title", "Author1"),
                            new Book(2, "K_Title", "Author2"),
                            new Book(3, "Z_Title", "Author3"),
                            new Book(4, "I_Title", "Author4")};
        OrderedArrayLibrary oal = new OrderedArrayLibrary(bookArray);

        System.out.println(Arrays.toString(oal.sortingById()));
        System.out.println(Arrays.toString(oal.sortingByTitle()));
    }
}
