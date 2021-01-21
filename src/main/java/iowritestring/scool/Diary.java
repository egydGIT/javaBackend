package iowritestring.scool;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Diary {

    public void newMark(Path file,int mark) {
        try {
            if (Files.exists(file)) {
                Files.writeString(file, "\n" + mark, StandardOpenOption.APPEND);
            }
            if (!Files.exists(file)) {
                Files.writeString(file, mark + "\n");
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Cant find file", e);
        }
    }

    public void average(Path file) {
        try {
            List<String> marks = Files.readAllLines(file);
            double sum = 0.0;
            for (String m: marks) {
                if (!m.substring(0, 1).equals("A")) {
                    sum += Double.parseDouble(m);
                }
            }

            Files.writeString(file, "\nAverage: "+ Math.round(sum) / marks.size(), StandardOpenOption.APPEND);

        } catch (IOException e) {
            throw new IllegalArgumentException("Cant find file", e);
        }
    }

    public static void main(String[] args) {
        Diary diary = new Diary();

        diary.newMark(Path.of("src/main/resources/tanulo_neve.txt"), 5);
        diary.newMark(Path.of("src/main/resources/tanulo_neve.txt"), 3);

        diary.average(Path.of("src/main/resources/tanulo_neve.txt"));

        diary.newMark(Path.of("src/main/resources/tanulo_neve.txt"), 1);
        diary.newMark(Path.of("src/main/resources/tanulo_neve.txt"), 5);

        diary.average(Path.of("src/main/resources/tanulo_neve.txt"));

    }


}
