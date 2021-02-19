package week14d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void createStudent() {
        Student s = new Student("John");
        assertEquals("John", s.getName());
        assertEquals(0, s.getNotes().size());
    }

    @Test
    void testAddNotes() {
        Student s = new Student("John");
        s.addNotes("biology", 5);
        s.addNotes("biology", 4);
        assertEquals(1, s.getNotes().size());
        assertEquals(2, s.getNotes().get("biology").size());
        assertEquals(5, s.getNotes().get("biology").get(0));
        assertEquals(4, s.getNotes().get("biology").get(1));



    }

}