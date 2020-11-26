package scoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassRecords {             // E-napló

    private String className;

    private Random rnd;

    private List<Student> student = new ArrayList<>();

    public ClassRecords(String className, Random rnd) {
        this.className = className;
        this.rnd = rnd;
    }

    public boolean addStudent(Student student) {
        // új diák hozzáadása
    }

    public boolean removeStudent(Student student) {
        // új diák eltávolítása
    }

    public String findStudentByName(String name) {
        // név szerint megkeres egy diákot az osztályban
    }

    public Student repetition() {
        // felelethez a listából random módon kiválaszt egy diákot
    }

    public double calculateClassAverage() {
        // osztályátlagot számol, minden diákot figyelembe véve
    }

    public double calculateClassAverageBySubject(Subject subject) {
        // tantárgy szerinti osztályátlagot számol
        // kihagyhatja azon diákokat, akiknek az adott tárgyból nincs jegye
    }

    public String listStudentNames() {
        // kilistázza a diákok neveit, vesszővel elválasztva
    }

    public List<StudyResultByName> listSudyResults() {
        // a diákok nevét és tanulmányi átlagát egy-egy új objektumba viszi
        // azok listáját adja vissza
    }

    public String getClassName() {
        return className;
    }

    private boolean isEmpty(String str) {
        // megvizsgálja, van-e üres v null értékű String paraméter
    }
}
