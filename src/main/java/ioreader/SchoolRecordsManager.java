package ioreader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SchoolRecordsManager {

    private Student student;

    //private List<Student> studentClass = new ArrayList<>();

    public void readGradesFromFile(String filePath) {
        Path file = Path.of(filePath);
        try (BufferedReader br = Files.newBufferedReader(file)) {
            String line;
            String name = null;
            List<Integer> marks = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                if (line.length() > 1) {
                    name = line;
                } else {
                    for( int i = 0; i < line.length(); i++) {
                        int mark = Integer.parseInt(line);
                        marks.add(mark);
                    }
                }
                student = new Student(name, marks);
                //studentClass.add(student);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Student getStudent() {
        return student;
    }

//    public List<Student> getStudentClass() {
//        return studentClass;
//    }

    public static void main(String[] args) {
        SchoolRecordsManager sr = new SchoolRecordsManager();

        sr.readGradesFromFile("grades.txt");
        System.out.println(sr.getStudent().getName());
        System.out.println(sr.getStudent().getMarks());

        System.out.println("Average: " + sr.getStudent().average());

        System.out.println(sr.getStudent().isIncrease());
    }
}
