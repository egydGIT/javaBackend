/*
package scoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ClassRecords {             // E-napló

    private String className;

    private Random rnd;

    private List<Student> students = new ArrayList<>();

    public ClassRecords(String className, Random rnd) {
        this.className = className;
        this.rnd = rnd;
    }

    public boolean addStudent(Student student) {
        // új diák hozzáadása

        for (Student s : students) {
            if (!s.getName().equals(student.getName())) {
                students.add(student);
            }
        }
        return true;
    }

    public boolean removeStudent(Student student) {
        // új diák eltávolítása

        for (Student s : students) {
            if (s.getName().equals(student.getName())) {
                students.remove(student);
            }
        }
        return true;
    }

    public String findStudentByName(String searchStudentName) {
        // név szerint megkeres egy diákot az osztályban

        for (Student s : students) {
            if (s.getName().equals(searchStudentName)) {
                System.out.println(s.toString());;
                return s.toString();
            }
        }
    }

    public Student repetition() {
        // felelethez a listából random módon kiválaszt egy diákot

        int repetitionNumber = new Random().nextInt(students.size()+1);
        for (int i = 0; i < students.size(); i++) {
            if (i == repetitionNumber) {
                System.out.println(students.subList(i, i+1).toString());
            }
        }
        return ;
    }
 */

/* ------------------
    public double calculateClassAverage() {
        // osztályátlagot számol, minden diákot figyelembe véve
    }

    public double calculateClassAverageBySubject(Subject subject) {
        // tantárgy szerinti osztályátlagot számol
        // kihagyhatja azon diákokat, akiknek az adott tárgyból nincs jegye
    }

    public String listStudentNames() {
        // kilistázza a diákok neveit, vesszővel elválasztva
        for (Student student : students) {
            students.listIterator();
        }
    }

    public List<StudyResultByName> listSudyResults() {
        // a diákok nevét és tanulmányi átlagát egy-egy új objektumba viszi
        // azok listáját adja vissza
    }
    */

/*
    public String getClassName() {
        return className;
    }

    private boolean isEmpty(String str) {
        // megvizsgálja, van-e üres v null értékű String paraméter

        if ("".equals(str) || str == null) {
            System.out.println("isEmpty");
        }
        return true;
    }

}


 */
