/*
Mai junior/mid-level feladat:
Készíts egy WordFilter osztályt, melyben van egy List<String> wordsWithChar(List<String> words, char c) metódus.
A metódus kiválógatja a paraméterül kapott String listából azokat a szavakat, melyekben előfordul a c karakter,
majd ezeket visszaadja egy listában. (edited)
 */

package week11d03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordFilter {

    public List<String> wordsWithChar(List<String> words, char c) {
        List<String> filteredWords = new ArrayList<>();
        for (String w: words) {
            for (int i = 0; i < w.length(); i++) {
                if(w.charAt(i) == c && !filteredWords.contains(w)) {
                    filteredWords.add(w);
                }
            }
        }
        return filteredWords;
    }


    public static void main(String[] args) {
        WordFilter wordFilter = new WordFilter();
        System.out.println(wordFilter.wordsWithChar(Arrays.asList("cat", "dog", "mouse"), 'o'));
    }

}
