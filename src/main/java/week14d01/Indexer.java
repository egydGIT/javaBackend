/*
Junior
Készíts egy Indexer osztályt, melynek van egy public Map<Character, List<String>> index(List<String> names) metódusa.
A feladat az, hogy egy indexet készítsünk a megadott nevek kezdőbetűiből (minden kezdőbetűt társítsunk az összes névvel,
mely ezzel a betűvel kezdődik). Példa:

System.out.println(new Indexer().index(Arrays.asList("Odon", "Lujza", "Abraham", "Magdolna")));
// {A=[Abraham], L=[Lujza], M=[Magdolna], O=[Odon]}
 */

package week14d01;

import java.util.*;

public class Indexer {

    public Map<Character, List<String>> index(List<String> names) {     // multi Map
        Map<Character, List<String>> result = new HashMap<>();
        for (String name: names) {
            char initial = name.charAt(0);              // név első karaktere = kezdőbetű
            if (!result.containsKey(initial)) {         // ha a Map-ben még nincs ilyen kulcs vagyis kezdőbetű
                result.put(initial, new ArrayList<>()); // akkor legyen + még egy üres lista az értékek vagyis a nevek tárolására
            }
            result.get(initial).add(name);              // kulcs szerinti lista kivétele, majd név hozzzáadása
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Indexer().index(Arrays.asList("Odon", "Lujza", "Abraham", "Magdolna", "Adam")));
    }
}
