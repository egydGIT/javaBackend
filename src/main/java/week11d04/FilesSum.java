/*
Junior
Adott az aktuális könyvtárban több, fájl, melynek a nevei: number00.txt, number03.txt, number20.txt, egészen 99-ig.
Nem minden fájl létezik, lehet, hogy bizonyos számhoz tartozó fájl kimaradt.
Olvasd be az állományból a benne lévő számot, és ezt összegezd!
Használd a Files.isRegularFile() metódust arra, hogy megnézd, létezik-e a fájl!
Használd a Files.readString() metódust a fájl beolvasására! A FilesSum osztály int sumNumbers() metódusába dolgozz!

 */

package week11d04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesSum {

    public int readFile(String fileName) {
        try {
            String fileContent = Files.readString(Path.of(fileName));       // fájl tartalom beolvasás
            int number = Integer.parseInt(fileContent);                     // fájl tartalom átalakítása számmá
            return number;                                                  // met vissz.t-i értéke
        } catch (IOException e) {
            throw new IllegalStateException("Can not find file.", e);
        }
    }

    public int sumNumbers() {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            String fileName = "src/main/resources/number" + ( i < 10 ? "0"+i : i ) + ".txt";
            // String fileName = String.format("number%02d.txt", i);  // 2 karakteren ábrázolja a számot, 0-val töltse fel
            // System.out.println(fileName);

            if (Files.isRegularFile(Path.of(fileName))) {             // létezik-e a file
                // System.out.println("found");                       // ha létezik, belemegy az if-be
                int number = readFile(fileName);                      // beolvassa a file-k tartalmát
                sum += number;                                        // összegzi
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(new FilesSum().readFile("src/main/resources/number20.txt"));
        System.out.println(new FilesSum().readFile("src/main/resources/number71.txt"));

        System.out.println(new FilesSum().sumNumbers());


    }

}
