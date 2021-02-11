package week12d05;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.URL;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class CovidTest {

    @Test
    void testWordCounter() {
        Covid c = new Covid();
        InputStream is = CovidTest.class.getResourceAsStream("/index.html");  // test esethez fájlt betölteni: getResourceAsStream
                                                // fájl az src/main/resources könyvtárban: kell /     főkönyvtárban: nem kell /
                                                // getResourceAsStream Steam-et ad vissza, met Path-t vár ->nem kompatibilis
                                                // met par-t módosítani: Reader-t várjon
        //Path file = Path.of();
        int counter = c.wordCounter("covid", new BufferedReader(new InputStreamReader(is)));
        assertEquals(4, counter);
    }

    @Test
    void testWordCounterWithSimpleFile() {
        Covid c = new Covid();
        // Path file = Path.of("src/main/resources/testdata.txt");                 // fájl -> file
        // InputStream is = CovidTest.class.getResourceAsStream("/testdata.txt");  // classpath-ról fájl -> new BufferedReader(new InputStreamReader(is))
        String sample = "alma\n,körte\n,meggy\nalma";                              // mem-ból String -> new BufferedReader(new StringReader(sample))
        try {
            URL url = new URL("https://index.hu");                            // hálózatról -> new BufferedReader(new InputStreamReader(is))
            InputStream is = url.openStream();
            int counter = c.wordCounter("covid", new BufferedReader(new InputStreamReader(is)));
            assertEquals(4, counter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}