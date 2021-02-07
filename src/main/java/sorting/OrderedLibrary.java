package sorting;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class OrderedLibrary {

    Set<Book> library = new TreeSet<>();

    public OrderedLibrary(Set<Book> library) {
        this.library = library;
    }

    public Book lendFirstBook() {
        Iterator<Book> iter = library.iterator();
        if (iter.hasNext()){
            return iter.next();
        }
        throw new NullPointerException("Libray is empty!");
    }

    public Set<Book> getLibrary() {
        return library;
    }

    public void setLibrary(Set<Book> library) {
        this.library = library;
    }
}
