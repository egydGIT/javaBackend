/*
Junior
Töltsd le az index.hu nyitólapját böngészőből, ez egy html állomány! Másold be a projektedbe (index.html) néven!
Ez egy szöveges állomány. Olvasd be, és számold meg, hány sorban szerepel a koronavírus szó!

 */

package week12d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Covid {

    // index.hu -> Crtl U, Ctrl A, Ctrl C  -> new file: index.html  Ctrl V

    public int wordCounter(String word) {
        Path file = Path.of("src/main/resources/index.html");
        try (BufferedReader br = new BufferedReader(Files.newBufferedReader(file))) {
            int counter = 0;    // összegzés tételéhez változó: lokális vátozó, nincs kezdőértéke, inicializálni kell
            String line;
            while ((line = br.readLine()) != null) {        // amíg talál beolvasható sort
                // line változóba elmenti a beolvasott sort - ha az tartalmaz karaktereket
                if (line.toLowerCase().contains(word)) {
                    // ha a beolvasott sor, kisbetűsítve, tartalmazza a met. par-ként átadott szót
                    counter++;                              // akkor a számlálóhoz adjon egyet
                }
            }
            return counter;
        } catch (IOException e) {
            throw new IllegalStateException("Can not read file.", e);
        }
    }


    public static void main(String[] args) {
        Covid covid = new Covid();
        System.out.println(covid.wordCounter("covid"));     // 4
        System.out.println(covid.wordCounter("vakcina"));   // 6
        System.out.println(covid.wordCounter("gazdaság"));  // 3
        System.out.println(covid.wordCounter("magyar"));    // 29


    }




}
