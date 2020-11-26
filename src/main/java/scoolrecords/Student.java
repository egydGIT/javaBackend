package scoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private List<Mark> marks = new ArrayList<>();           // read only ?

    private String name;

    public Student(String name) {
        this.name = name;
    }

    public void grading(Mark mark) {
        // érdemjegy rögzítése
    }

    public double calculateAverage() {
        // teljes átlag számolása
    }

    public double calculateSubjectAverage(Subject subject) {
        // tantárgyhoz tartozó átlag számítása
    }

    public String getName() {
        return name;
    }

    public boolean equals(Object ) {
        // ??
    }

    private boolean isEmpty(String str) {
        // megvizsgálja, van-e üres v null értékű String paraméter
    }

    @Override                                                // tesztesetekben a végleges formátum
    public String toString() {                               // diák szöveges reprezentációja
        return "Student{" +
                "marks=" + marks +
                ", name='" + name + '\'' +
                '}';
    }
}
