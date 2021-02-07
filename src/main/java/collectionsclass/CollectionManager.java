package collectionsclass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionManager {

    private List<Book> library;

    public CollectionManager(List<Book> library) {
        this.library = library;
    }

    public List<Book> createUnmodifiableLibrary() {     //módosíthatatlan listát eredményez
        List<Book> unmodifiableLibrary = Collections.unmodifiableList(library);
        return unmodifiableLibrary;
    }

    public List<Book> reverseLibrary() {                //az eredeti lista másolatán dolgozik!
        List<Book> copyLibrary = new ArrayList<>(library);
        Collections.sort(copyLibrary);
        Collections.reverse(copyLibrary);
        return copyLibrary;
    }

    public Book getFirstBook() {                        //a legrégebbi (legkisebb id) könyvet adja vissza
        List<Book> copyLibrary = new ArrayList<>(library);
        return Collections.min(copyLibrary);
    }

    public Book getLastBook() {                         // a legújabb (legnagyobb id) könyvet adja vissza
        List<Book> copyLibrary = new ArrayList<>(library);
        return Collections.max(copyLibrary);
    }

    public List<Book> getLibrary() {
        return library;
    }

    public static void main(String[] args) {

        List<Book> library = Arrays.asList(new Book(123, "Title1", "Author1"),
                new Book(456, "Title2", "Author2"),
                new Book(789, "Title3", "Author3"));

        CollectionManager cm = new CollectionManager(library);
        System.out.println(cm.getLibrary());
        //System.out.println(cm.createUnmodifiableLibrary().add(new Book(456, "Title2", "Author2"))); // UnsupportedOperationException
        System.out.println(cm.reverseLibrary());
        System.out.println(cm.getFirstBook());
        System.out.println(cm.getLastBook());


    }

}
