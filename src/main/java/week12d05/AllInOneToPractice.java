package week12d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;

public class AllInOneToPractice {

    // index.hu -> Crtl U, Ctrl A, Ctrl C  -> new file: index.html  Ctrl V

    // 1.
    // Csak Stringet vár
    // file elérési útja a met-ban - ezzel a met-sal csak ebben a fájlban lehet keresni
    public int wordCounter(String word) {
        Path file = Path.of("src/main/resources/index.html");
        try (BufferedReader br = Files.newBufferedReader(file)) {
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

    // 2.
    // korábban bent definiált vált-t par-be kivinni -> tesztelhetőbb, paraméterezhető
    public int wordCounter(String word, Path file) {
        try (BufferedReader br = new BufferedReader(Files.newBufferedReader(file))) {
            int counter = 0;
            String line;
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains(word)) {
                    counter++;
                }
            }
            return counter;
        } catch (IOException e) {
            throw new IllegalStateException("Can not read file.", e);
        }
    }

    // 3.
    // fájlt nem a met-on belül nyitom meg, hanem BufferedReader-t adok át
    // kaphat: fájlt, classpath-ről fájlt, memóriából String-t, hálózatról)
    public int wordCounter(String word, BufferedReader reader) {    // fájlt vhonnan beolvasni: met. param: Reader, Writer, Input-, OutputStream
                                                                    // BufferedReader tud sort olvasni

        try {                                               // Readert az hozza létre, aki maghívja a met-t
            int counter = 0;                                        // -> main: Files.newBufferedReader((Path.of("")))  - forrás egy fájl
            String line;                                            // -> test: getResourceAsStream()
                                                                    //          new BufferedReader(new InputStreamReader(is))
            while ((line = reader.readLine()) != null) {    // BufferedReader readLine() met-t
                if (line.toLowerCase().contains(word)) {
                    counter++;
                }
            }
            return counter;
        } catch (IOException e) {
            throw new IllegalStateException("Can not read file.", e);
        }
    }

    public static void main(String[] args) {
        AllInOneToPractice toPractice = new AllInOneToPractice();

        // 1.
        System.out.println(toPractice.wordCounter("covid"));                // 4

        // 2.
        Path file = Path.of("src/main/resources/index.html");
        System.out.println(toPractice.wordCounter("covid", file));     // 4

        // 3.a
        BufferedReader reader = null;
        try {
            reader = Files.newBufferedReader(Path.of("src/main/resources/index.html"));
            System.out.println(toPractice.wordCounter("covid", reader));                    // 4
            // ha végigolvassa, újra létre kell hozni, h az elejéről kezdje -> fájlt többször meg kell nyitni
            reader = Files.newBufferedReader(Path.of("src/main/resources/index.html"));
            System.out.println(toPractice.wordCounter("gazdaság", reader));                 // 3
        } catch (IOException e) {
            throw new IllegalStateException("Cant...", e);
        }

    }


}
