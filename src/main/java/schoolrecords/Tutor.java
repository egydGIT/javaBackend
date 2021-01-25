package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Tutor {

    private String name;

    private List<Subject> taughtSubjects = new ArrayList<>();

    public Tutor(String name, List<Subject> taughtSubjects) {
        this.name = name;
        this.taughtSubjects = taughtSubjects;
    }

    public boolean tutorTeachingSubject(Subject subject) {
        for (Subject taughtSubject : taughtSubjects) {
            if (taughtSubject.equals(subject)) {
                System.out.println("Igen, ezt a tantárgyat tanítja.");
                return true;
            }
        }
        System.out.println("Ezt a tantárgyat nem tanítja.");
        return false;
    }

    public String getName() {
        return name;
    }
}
