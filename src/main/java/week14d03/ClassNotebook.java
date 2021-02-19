package week14d03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClassNotebook {

    private List<Student> students;

    public ClassNotebook(List<Student> students) {
        this.students = students;
    }

    public List<Student> sortNoteBook() {
        List<Student> result = new ArrayList<>(students);       // listáról másolat -> copy konstruktor
        Collections.sort(result);                               // abc sorrendbe rendezi a másolatot
        return result;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Student> getStudentsCopy() {
        return new ArrayList<>(students);
    }

    public static void main(String[] args) {
        ClassNotebook cb = new ClassNotebook(new ArrayList<>(List.of(
                new Student("Jane"), new Student("Jack"), new Student("John"))));
        System.out.println(cb.getStudents());

        cb.getStudents().get(0).addNotes("Biology", 3);
        cb.getStudents().get(0).addNotes("Biology", 5);
        cb.getStudents().get(0).addNotes("Biology", 4);

        System.out.println(cb.getStudents().get(0));

        Student s = new Student("Joe");
        cb.getStudents().add(s);

        System.out.println(cb.getStudents());

        List<Student> studentsSorted = cb.sortNoteBook();
        System.out.println(studentsSorted);


    }
}
