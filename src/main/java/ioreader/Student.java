package ioreader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class  {

    private String name;

    private List<Integer> marks = new ArrayList<>();

    public Student(String name, List<Integer> marks) {
        this.name = name;
        this.marks = marks;
    }

    public int average() {
        double sum = 0;
        for (Integer m : marks) {
            sum += m;
        }
        int average = (int) (Math.round(sum / marks.size()));
        return average;
    }

    public boolean isIncrease() {
        for (int i = 0; i < marks.size(); i++) {
            if (marks.get(i) < marks.get(i+1)) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getMarks() {
        return marks;
    }


}
