package arraylist;

import java.util.ArrayList;
import java.util.List;

public class Books {
    ArrayList<String> books = new ArrayList<>();

    public void add(String bookTitle) {
        books.add(bookTitle);
    }

    public List<String> findAllByPrefix(String prefix) {
        // books.contains(prefix);
        List<String> prefixFind = new ArrayList<>();                  // Létrehoztam egy 2. listát, amibe elmentem azt az elemet, amit talál
        for (String book : books) {                                   // a ciklus, ami végiglépked az 1. listán.
            if (book.equals(prefix)) {                                // Ha: a for-each ciklus változója, ami lépked az 1. listán megegyezik/tartalmazza...
                prefixFind.add(book);                                 // Akkor adja hozzá a 2. listához.
            }
        }
        return prefixFind;                                            // Térjen vissza a 2. listával (ami elvileg csak a feltételben meghat. egyező elemeket tartalmazza
    }

    public List<String> getTitles() {
        return books;
    }

    public static void main(String[] args) {
        Books books = new Books();

        books.add("Négyszögletű kerekerdő");
        books.add("Neuroanatómia");
        books.add("Négyzetes függvény zérushelyeinek meghatározása");
        System.out.println("Kilistázás: " + books.getTitles());

        books.findAllByPrefix("Négy");
        System.out.println("Keresés eredménye: " + books.getTitles());           // De!   A teljes listát visszaadja.

    }
}
