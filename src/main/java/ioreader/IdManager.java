package ioreader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class IdManager {

    private List<String> ids = new ArrayList<>();

    public void readIdsFromFile(String filePath) {
        Path file = Path.of(filePath);
        try (BufferedReader br = Files.newBufferedReader(file)){
            String line;
            while ((line = br.readLine()) != null) {
                ids.add(line);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("File is not exists. " + e);
        }

    }

    public List<String> getIds() {
        return ids;
    }


    public static void main(String[] args) {
        IdManager idManager = new IdManager();
        idManager.readIdsFromFile("src/main/resources/idnumbers.txt");
        System.out.println(idManager.getIds());


    }
}
