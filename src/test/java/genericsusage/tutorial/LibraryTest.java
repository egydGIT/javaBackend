package genericsusage.tutorial;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test
    public void shouldThrowExceptionIfArgumentIsNull() {
        assertThrows(NullPointerException.class, () -> new Library().getFirstBookWithGenerics(null));
    }

    @Test
    public void shouldThrowExceptionIfArgumentIsEmptyList() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Library().getFirstBookWithGenerics(Collections.emptyList()));
        assertEquals("Argument should not be empty!", ex.getMessage());
    }

    @Test
    public void shouldReturnFirst() {
        assertEquals("Egri Csillagok", new Library().getFirstBookWithGenerics(Arrays.asList(new Book("Egri Csillagok"))).getTitle());
    }



    @Test
    public void shouldThrowExceptionIfArgumentIsNull2() {
        assertThrows(NullPointerException.class, () -> new Library().getFirstBookWithOutGenerics(null));
    }

    @Test
    public void shouldThrowExceptionIfArgumentIsEmptyList2() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Library().getFirstBookWithOutGenerics(new ArrayList()));
        assertEquals("Argument should not be empty!", ex.getMessage());
    }

    @Test
    public void shouldThrowExceptionAddingDifferentObjects2() {
        Library library = new Library();
        Exception ex = assertThrows(ClassCastException.class, () -> library.getFirstBookWithOutGenerics(Arrays.asList("", "", "")));
        assertEquals("Not a book", ex.getMessage());
    }

    @Test
    public void shouldReturnFirst2() {
        assertEquals("Egri Csillagok", new Library().getFirstBookWithOutGenerics(Arrays.asList(new Book("Egri Csillagok"), new Book("Antigoné"))).getTitle());
    }
}