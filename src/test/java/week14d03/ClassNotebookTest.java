package week14d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClassNotebookTest {

    @Test
    void manipulate() {
        ClassNotebook cn = new ClassNotebook(new ArrayList<>(List.of(
                new Student("Jane"), new Student("Jack"))));
        cn.getStudents().add(new Student("John"));
        assertEquals(3, cn.getStudents().size());

        cn.getStudentsCopy().add(new Student("Joe"));
                        // lista másolatát adja vissza, ezen keresztül nem tudjuk az eredeti listát manipulálni
        assertEquals(3, cn.getStudents().size());
    }

    @Test
    void testSortNoteBook() {
        ClassNotebook cn = new ClassNotebook(new ArrayList<>(List.of(
                new Student("Jane"), new Student("Jack"), new Student("John"))));

        assertEquals("Jane", cn.getStudents().get(0).getName());

        List<Student> result = cn.sortNoteBook();
        assertEquals("Jack", result.get(0).getName());


    }

}