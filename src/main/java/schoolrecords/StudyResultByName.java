package schoolrecords;

public class StudyResultByName {

    private String studentName;

    private double studyAverage;

    public StudyResultByName(String studentName, double studyAverage) {         // pareméter-sorrend ?
        this.studentName = studentName;
        this.studyAverage = studyAverage;
    }

    public String getStudentName() {
        return studentName;
    }

    public double getStudyAverage() {
        return studyAverage;
    }
}
