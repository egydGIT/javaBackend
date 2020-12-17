package week04d02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Search {

    /*
    2020-11-18 (week04d02)
        A Search osztályban írj egy getIndexesOfChar() metódust, mely első paraméterként vár egy String értéket,
        második paraméterként egy char értéket! Visszaad egy listát, melyben visszaadja,
        hogy a karakter hanyadik indexeken szerepel az első paraméterként átadott listában.

        Pl.: almafa szóban a a karakter: 0, 3, 5.
     */

    private String str;
    private char c;

    public List<Integer> getIndexesOfChar(String str, char c) {
        if (isEmpty(str, c)) {
            throw new IllegalArgumentException("Invalid parameters!");
        }
        List<Integer> indexOfChar = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                indexOfChar.add(i);
            }
        }
        return indexOfChar;
    }

    public List<Integer> getMatchingChar(String str, char c) {
        if (isEmpty(str, c)) {
            throw new IllegalArgumentException("Invalid parameters!");
        }
        List<Integer> indexOfChar = new ArrayList<>();
        Scanner scanner = new Scanner(str).useDelimiter("");
        while (scanner.hasNext()) {
            indexOfChar.add(scanner.next().indexOf(c));
        }
        return indexOfChar;
    }

    private boolean isEmpty(String str, char c) {
        String cString = Character.toString(c);
        return str == null || "".equals(str.trim()) || cString == null || "".equals(cString.trim());
    }

    public static void main(String[] args) {
        Search search = new Search();
        System.out.println("Index of: " + search.getIndexesOfChar("almafa", 'a'));
        System.out.println("Matching: " + search.getMatchingChar("almafa", 'a'));
        // System.out.println(search.getIndexesOfChar("", 'b'));
    }

    /*
        Index of: [0, 3, 5]
        Matching: [0, -1, -1, 0, -1, 0]
     */
}
