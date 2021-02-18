package week13d03;

public class Subject {

    private String teacherName;
    private String subjectName;
    private String className;
    private int numberOfLessons;

    public Subject(String teacherName, String subjectName, String className, int numberOfLessons) {
        this.teacherName = teacherName;
        this.subjectName = subjectName;
        this.className = className;
        this.numberOfLessons = numberOfLessons;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getClassName() {
        return className;
    }

    public int getNumberOfLessons() {
        return numberOfLessons;
    }

    @Override
    public String toString() {
        return "\n" + "Subject: " +
                " " + teacherName  +
                ", " + subjectName  +
                ", " + className  +
                ", " + numberOfLessons;
    }
}
