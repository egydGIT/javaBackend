package collectionscomp;

import java.text.Collator;
import java.util.*;

public class OrderedLibrary {

    private List<Book> libraryBooks = new LinkedList<>();

    public OrderedLibrary(List<Book> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public List<Book> orderedByTitle() {          // Alapértelmezett a cím szerinti rendezés.
        List<Book> libraryBooksCopy = new ArrayList<>(libraryBooks);
        Collections.sort(libraryBooksCopy);           // Comparable if compareTo() met a Trainers oszt-ban implementálva
        return libraryBooksCopy;                      // ez a compareTo() met a tittle String compareTo() met-hoz delegál
    }

    public List<Book> orderedByAuthor() {           // külön oszt-ban valósítsuk meg a szerző szerinti rendezéshez szükséges Comparator osztályt.
        List<Book> libraryBooksCopy = new ArrayList<>(libraryBooks);
        Collections.sort(libraryBooksCopy, new AuthorComparator());
        return libraryBooksCopy;
    }

    public class AuthorComparator implements Comparator<Book> {        // belső osztály, a szerző szerinti rendezéshez

        @Override
        public int compare(Book o1, Book o2) {
            return o1.getAuthor().compareTo(o2.getAuthor());
        }
    }

    public List<Book> orderedByAuthorWithAnonymusInnerClass() {           // Comparator anonymus inner class segítségével
        List<Book> libraryBooksCopy = new ArrayList<>(libraryBooks);
        Collections.sort(libraryBooksCopy, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getAuthor().compareTo(o2.getAuthor());
            }
        });
        return libraryBooksCopy;
    }

    public List<String> orderedByTitleLocale(Locale locale) {       // ékezetes karaktereket is figyelembe vevő String rendezés
        List<String> libraryBooksTitles = new ArrayList<>();
        for (Book book : libraryBooks) {
            libraryBooksTitles.add(book.getTitle());
        }
        // Collections.sort(libraryBooksTitles, Collator.getInstance(new Locale("hu", "HU")));

        Collator hungarianCollator = Collator.getInstance(locale);
        hungarianCollator.setStrength(Collator.PRIMARY);                // ??
        Collections.sort(libraryBooksTitles, hungarianCollator);

        return libraryBooksTitles;
    }

    public List<Book> getLibraryBooks() {
        return libraryBooks;
    }

    public List<String> getLibraryBookTitles(List<Book> libraryBooks) {
        List<String> justTitles = new ArrayList<>();
        for (Book b: libraryBooks) {
            justTitles.add(b.getTitle());
        }
        return justTitles;
    }


    public static void main(String[] args) {
        List<Book> libraryBooks = new ArrayList<>(Arrays.asList(
                new Book(123, "A_Title", "Z_Author"),
                new Book(456, "K_Title", "M_Author"),
                new Book(789, "C_Title", "O_Author")));
        OrderedLibrary ol = new OrderedLibrary(libraryBooks);

        System.out.println("All: " + ol.getLibraryBooks());

        System.out.println("Author: " + ol.orderedByAuthor());
        System.out.println("Author2: " + ol.orderedByAuthorWithAnonymusInnerClass());
        System.out.println("Title: " + ol.orderedByTitle());

        System.out.println("Author: " + ol.getLibraryBookTitles(ol.orderedByAuthor()));
        System.out.println("Author2: " + ol.getLibraryBookTitles(ol.orderedByAuthorWithAnonymusInnerClass()));
        System.out.println("Title: " + ol.getLibraryBookTitles(ol.orderedByTitle()));

//        List<Book> libraryBooksHu = new ArrayList<>(Arrays.asList(
//                new Book(123, "Á_Title", "Ó_Author"),
//                new Book(456, "K_Title", "Ny_Author"),
//                new Book(789, "Ü_Title", "O_Author")));
//        OrderedLibrary ol2 = new OrderedLibrary(libraryBooksHu);
//
//        System.out.println("Locale: " + ol2.orderedByTitleLocale(new Locale("hu", "HU")));




    }
}
