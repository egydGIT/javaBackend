package iowritestring.scool;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Diary {

//    public void newMarkMy(String studentName,int mark) {
//        Path file = Path.of(studentName + ".txt");
//        try {
//            if (Files.exists(file)) {
//                Files.writeString(file, mark + "\n", StandardOpenOption.APPEND);
//            }
//            else  {
//                Files.writeString(file, mark + "\n");
//            }
//        } catch (IOException e) {
//            throw new IllegalArgumentException("Cant find file", e);
//        }
//    }

    public void newMark(Path file, int mark) {
        try {
            if (Files.exists(file)) {
                Files.writeString(file, mark + "\n", StandardOpenOption.APPEND);
            } else {
                Files.writeString(file, Integer.toString(mark));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't open file", e);
        }
    }

//    public void averageMy(Path file) {
//        try {
//            List<String> marks = Files.readAllLines(file);
//            double sum = 0.0;
//            for (String m: marks) {
//                if (!m.substring(0, 1).equals("A")) {
//                    sum += Double.parseDouble(m);
//                }
//            }
//            // String sum2 = String.format("Average: %.2" + sum);
//            Files.writeString(file, "Average: " + (Math.round(sum) / marks.size()) + "\n", StandardOpenOption.APPEND);
//
//        } catch (IOException e) {
//            throw new IllegalArgumentException("Cant find file", e);
//        }
//    }

    public void average(Path file) {
        try {
            List<String> myFile = Files.readAllLines(file);
            double sum = 0.0;
            for (String s : myFile) {
                sum += Double.parseDouble(s);
            }

            Files.writeString(file, "Average: " + (sum / myFile.size()), StandardOpenOption.APPEND);

        } catch (IOException e) {
            throw new IllegalStateException("Can't open file", e);
        }
    }

    public static void main(String[] args) {
//        Diary diary = new Diary();
//
//        diary.newMarkMy("tanulo_neve", 5);
//        diary.newMarkMy("tanulo_neve", 3);
//
//        diary.averageMy(Path.of("tanulo_neve.txt"));
//
//        diary.newMarkMy("tanulo_neve", 1);
//        diary.newMarkMy("tanulo_neve", 5);
//
//        diary.averageMy(Path.of("tanulo_neve.txt"));

    }


}
