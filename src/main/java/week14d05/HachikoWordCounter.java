/*
Junior
A examples/week14d05/hachiko.srt van a Hachiko film felirata. Írj egy countWords() metódust, mely paraméterül várja a fájlt,
varargsban szavakat. Megszámolja, hogy melyik szó hány sorban szerepel a szövegben. Legyenek mondjuk a beadott szavak:
"Hachiko", "haza", "pályaudvar", "jó"
 */
package week14d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class HachikoWordCounter {

    public Map<String, Integer> countWords(BufferedReader reader, String... words) {            // hibakezelés külön!
        try {
            return processLines(reader, words);
        } catch (IOException e) {
            throw new IllegalStateException("Can not read file.", e);
        }
    }
                                                                                              // visszat.ért: Map: kulcs=szó, érték=hányszro>
    private Map<String, Integer> processLines(BufferedReader reader, String... words) throws IOException {  // param: br, megkeresendő szavak
        Map<String, Integer> result = new HashMap<>();
        String line;
        while ((line = reader.readLine()) != null ) {
            // System.out.println(line);
            countWordsInLine(line, result, words);
        }
        return result;
    }

    private void countWordsInLine(String line, Map<String, Integer> result, String... words) {
        for (String word: words) {                                          // végigmegy a szavakon
            if (line.toLowerCase().contains(word.toLowerCase())) {          // ha sor tartalmazza a szót
                incrementCounter(result, word);
            }
        }
    }

    private void incrementCounter(Map<String, Integer> result, String word) {
        Integer prevValue = result.get(word);   // result-ból kiveszem a szóhoz tartozó értéket
        if (prevValue == null) {                // ha a szóhoz még nem tartozik érték
            result.put(word, 1);                // resultba be kell tanni az adott szóval az 1-t
        }
        else {
            result.put(word, prevValue + 1);    // be kell tenni a szóval az előző értéket eggyel megnövelve
        }

//                        if (result.containsKey(word)) {       // kétszer keres a map-ben
//                            result.put(word, 1);
//                        }
//                        else {
//                            Integer prevValue = result.get(word);
//                            result.put(word, prevValue + 1);
//                        }
    }



    public static void main(String[] args) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of("src/test/resources/hachiko.srt"))) {     // Charset.forName("windows-1250")
            System.out.println(new HachikoWordCounter().countWords(reader, "Hach", "haza", "pályaudvar", "jó"));

        } catch (IOException e) {
            throw new IllegalStateException("Can not read file.", e);
        }
        // try-with-resources: egy nem látható (implicit) finally ágban meghívja a reader.cole() met-t

        // {haza=16, jó=38, pályaudvar=6, Hach=84}

    }

}
