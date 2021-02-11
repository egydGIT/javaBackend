/*
Junior
Töltsd le az index.hu nyitólapját böngészőből, ez egy html állomány! Másold be a projektedbe (index.html) néven!
Ez egy szöveges állomány. Olvasd be, és számold meg, hány sorban szerepel a koronavírus szó!

 */

package week12d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;

public class Covid {

    // index.hu -> Crtl U, Ctrl A, Ctrl C  -> new file: index.html  Ctrl V

    public int wordCounter(String word, BufferedReader reader) {    // fájlt vhonnan beolvasni: met. param: Reader, Writer, Input-, OutputStream
                                                                    // BufferedReader tud sort olvasni
                                                                    // Readert az hozza létre, aki maghívja a met-t
                                                                            // -> main: Files.newBufferedReader((Path.of("")))  - forrás egy fájl
                                                                            // -> test: new BufferedReader(new InputStreamReader(is))
        try {
            int counter = 0;    // összegzés tételéhez változó: lokális vátozó, nincs kezdőértéke, inicializálni kell
            String line;
            while ((line = reader.readLine()) != null) {        // amíg talál beolvasható sort
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
        // Path file = Path.of("src/main/resources/index.html");  // korábban bent definiált vált-t par-be kivinni -> tesztelhetőbb a met.

        Covid covid = new Covid();
        BufferedReader reader = null;
        try {
            reader = Files.newBufferedReader(Path.of("src/main/resources/index.html"));
            System.out.println(covid.wordCounter("covid", reader));     // 4
            reader = Files.newBufferedReader(Path.of("src/main/resources/index.html"));  // ha végigolvassa, újra létre kell hozni, h az elejéről kezdje
            System.out.println(covid.wordCounter("gazdaság", reader));     // 3
        } catch (IOException e) {
            throw new IllegalStateException("Cant...", e);
        }



    }




}
