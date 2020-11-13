package arraylist;

import java.util.ArrayList;
import java.util.List;

public class Books {
    ArrayList<String> books = new ArrayList<>();

    public void add(String bookTitle) {
        books.add(bookTitle);
    }

/*
    public void findAllByPrefix(String prefix) {
        books.contains(prefix);
    }

 */

    public List<String> getTitles() {
        return books;
    }

    public static void main(String[] args) {
        Books books = new Books();

        books.add("Négyszögletű kerekerdő");
        books.add("Neuroanatómia");
        System.out.println(books.getTitles());

    }
}
