package ioreader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SchoolRecordsManager {

    private Student student;

    private List<Student> studentClass = new ArrayList<>();

    public void readGradesFromFileMy(String filePath) {
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

    public void readGradesFromFile(String fileName) {
        Path file = Path.of("src/main/resources/" + fileName);
        try (BufferedReader br = Files.newBufferedReader(file)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(" ");
                List<Integer> grades = new ArrayList<>();
                for (int i = 1; i < temp.length; i++) {
                    grades.add(Integer.parseInt(temp[i]));
                }
                Student s = new Student(temp[0], grades);
                studentClass.add(s);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't read file!", e);
        }
    }

    public double classAverage(){
        double sum = 0.0;
        for(Student s: studentClass){
            sum += s.average();
        }
        return sum / studentClass.size();

    }

    public Student getStudent() {
        return student;
    }

    public List<Student> getStudentClass() {
        return new ArrayList<>(studentClass);
    }

    public static void main(String[] args) {
        SchoolRecordsManager sr = new SchoolRecordsManager();

        sr.readGradesFromFileMy("src/main/resources/grades.txt");
        System.out.println(sr.getStudent().getName());
        System.out.println(sr.getStudent().getMarks());

        System.out.println("Average: " + sr.getStudent().average());

        System.out.println(sr.getStudent().isIncrease());
    }
}
