package week06d01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListSelector {

    /*
    Junior
    Írj egy olyan metódust az ListSelector osztályban, mely egy kapott listából minden második elemet kiválogat,
    és egy szövegként összerak, szögletes zárójelek között. A páros megállapítása index szerint működik.
    Azaz az első, nulla indexű elem páros, a második, azaz egyes indexű elem páratlan, stb.
    Ha üres a lista, akkor üres stringet adjunk vissza.
    Ha a paraméterül kapott lista null, akkor dobj IllegalArgumentExceptiont a metódusban!
     */

    private List<String> words = new ArrayList<>();

    public List<String> listSelector(List<String> words) {
        List<String> everySecondWord = new ArrayList<>();
        if (words == null) {
            throw new IllegalArgumentException("List contains nothing.");
        }
        for ( int i = 0; i < words.size(); i+=2) {
            everySecondWord.add(words.get(i));
        }
        return everySecondWord;
    }

    public static void main(String[] args) {
        ListSelector listSelector = new ListSelector();
        List<String> words = Arrays.asList("első", "második", "harmadik", "negyedik", "ötödik");
        System.out.println(listSelector.listSelector(words));

        List<String> wordsEmpty = Arrays.asList();
        System.out.println(listSelector.listSelector(wordsEmpty));

        System.out.println(listSelector.listSelector(null));


    }
}
