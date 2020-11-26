package scoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Tutor {

    private String name;

    private List<Subject> taughtSubject = new ArrayList<>();

    public Tutor(List<Subject> taughtSubject) {
        this.taughtSubject = taughtSubject;
    }

    public boolean tutorTeachingSubject(Subject subject) {

    }

    public String getName() {
        return name;
    }
}
