package ioprintwriter;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SalaryWriter {

    private List<String> names = new ArrayList<>();

    public SalaryWriter(List<String> names) {
        this.names = names;
    }

    public void writeNamesAndSalaries(Path file) {
        try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(file))) {
            for(String name: names) {
                pw.print(name);
                pw.print(": ");
//                if (name.contains("Dr")) {                                // külön metódusba ki lehet szervezni
//                    pw.println(500_000);
//                }
//                if (name.contains("Mrs") || name.contains("Mr")) {
//                    pw.println(200_000);
//                }
//                if (!name.contains("Dr") && !name.contains("Mrs") && !name.contains("Mr")) {
//                    pw.println(100_000);
//                }
                pw.println(discrimination(name));
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Cant find file. " + file, e);
        }
    }

    public int discrimination(String name) {
        if (name.contains("Dr")) {
            return 500_000;
        }
        if (name.contains("Mr") || name.contains("Mrs")) {
            return 200_000;
        }
        else {
            return 100_000;
        }
    }

    public List<String> getNames() {
        return names;
    }


    public static void main(String[] args) {
        SalaryWriter salaryWriter = new SalaryWriter(List.of("Dr John Doe", "Mrs Jane Doe", "Jack"));
        salaryWriter.writeNamesAndSalaries(Path.of("src/main/resources/salarywriter.txt"));
    }
}
