package week08d03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringLists {

    /*
    Junior
    Készíts week08d03 csomagban egy StringLists osztályt és benne egy
    stringListsUnion(List<String> first, List<String> second) metódust, mely két string listát vár paraméterül
    és visszaadja az uniójukat. Az úniónak minden elemet tartalmaznia kell mindkét listából,
    de egy elem nem szerepelhet kétszer!
     */

    public List<String> stringListsUnion(List<String> first, List<String> second) {
        List<String> together = new ArrayList<>(first);
        for (String s: second) {
            if (!together.contains(s)) {
                together.add(s);
            }
        }
        return together;
    }

    public static void main(String[] args) {

        StringLists stringLists = new StringLists();

        List<String> first = Arrays.asList("egy", "kettő", "három");
        List<String> second = Arrays.asList("három", "négy", "öt");

        System.out.println(stringLists.stringListsUnion(first, second));

    }
}

