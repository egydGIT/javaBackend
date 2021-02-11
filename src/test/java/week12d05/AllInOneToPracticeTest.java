package week12d05;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.URL;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class AllInOneToPracticeTest {


    // 2.
    // Fájlt
    @Test
    void testWordCounter() {
        AllInOneToPractice toPractice = new AllInOneToPractice();
        Path file = Path.of("src/main/resources/index.html");
        int counter = toPractice.wordCounter("covid", file);
        assertEquals(4, counter);
    }

    @Test
    void testWordCounterWithSimpleFile() {
        AllInOneToPractice toPractice = new AllInOneToPractice();
        Path file = Path.of("src/main/resources/testdata.txt");
        int counter = toPractice.wordCounter("semmi", file);
        assertEquals(2, counter);
    }


    // 3.b
    // Classpath-ról fájl
    @Test
    void testWordCounterWithGetResourceAsStream() {
        AllInOneToPractice toPractice = new AllInOneToPractice();
        InputStream is = CovidTest.class.getResourceAsStream("/index.html");  // test esethez fájlt betölteni: getResourceAsStream
                                       // fájl az src/main/resources könyvtárban: kell /     főkönyvtárban: nem kell /
                                       // getResourceAsStream Steam-et ad vissza, met Path-t vár ->nem kompatibilis
                                       // met par-t módosítani: Reader-t várjon
        //Path file = Path.of("src/main/resources/index.html");
        int counter = toPractice.wordCounter("covid", new BufferedReader(new InputStreamReader(is)));
                    // InputStream-ből létrehozott Reader: new InputStreamReader(is) -> BufferedReader-t vár -> be kell csomagolni BufferedR-be
                    // new BufferedReader(new InputStreamReader(is))) -> Reader-t vár
        assertEquals(4, counter);
    }


    // 4.
    // Forrás nem egy fájl, hanem memóriában Sting
    @Test
    void testWordCounterWithStringReader() {
        AllInOneToPractice toPractice = new AllInOneToPractice();
        // InputStream is = CovidTest.class.getResourceAsStream("/index.html");
        String sample = "alma\n,körte\n,meggy\nalma";
        int counter = toPractice.wordCounter("alma", new BufferedReader(new StringReader(sample)));
        assertEquals(2, counter);
    }


    // 5.
    // hálózatról
    @Test
    void testWordCounterWithOpenStream() {
        AllInOneToPractice toPractice = new AllInOneToPractice();
        // InputStream is = CovidTest.class.getResourceAsStream("/index.html");
        // String sample = "alma\n,körte\n,meggy\nalma";
        try {
            URL url = new URL("https://index.hu");      // URL átírható
            InputStream is = url.openStream();
            int counter = toPractice.wordCounter("covid", new BufferedReader(new InputStreamReader(is)));
            assertEquals(5, counter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}