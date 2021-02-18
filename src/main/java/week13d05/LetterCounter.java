/*
Junior
Írj egy metódust, amely megszámolja, hogy hány különböző betű van egy szóban. A kis és nagybetűk közötti különbség nem számít!
A space-eket, számjegyeket, stb. ne vegye figyelembe! Csak az angol ábécé betűit!
 */

package week13d05;

import java.util.*;

public class LetterCounter {

    // 1.
    private int min;        // 97 = a  karakterkódja
    private int max;        // 122 = z

    public LetterCounter(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int countLetter(String word) {
        List<Character> numberOfCharacters = new ArrayList<>();
        String wordToLowerCase = word.toLowerCase();
        int number;
        for (int i = 0; i < wordToLowerCase.length(); i++) {
            number = wordToLowerCase.charAt(i);   // charAt(): char-t ad vissza -> int: ennek a bájtkódja  = implicit kasztolás
            // number vált-ban i-dik karakter karakterkódja
            if (min <= number && number <= max) {
                if (!(numberOfCharacters.contains(wordToLowerCase.charAt(i)))) {   // ha a lista nem tartalmazza a String i-dik karakterét
                    // Set ezt az ellenőrzést kiváltaná
                    numberOfCharacters.add(wordToLowerCase.charAt(i));              // akkor hozzáadja
                }
            }
        }
        return numberOfCharacters.size();

    }


    // 2.
    public int countCharacter(String word) {
        char[] arr = word.toLowerCase().toCharArray(); // egy utasításban hív 2 met-t, de kül. példányokon - nem klasszikus met. chainig
                    // .toLowerCase() -> új Stringet ad vissza, ezen hívja a köv met-t
                    // egyik met-nak a vissz.ért-e egy másik obj, majd ennek az obj-nak hívja meg az egyik met-át
                    // .toCharArray() -> contain the character sequence represented by this string.
        // System.out.println(arr);  -> apple
        Set<Character> characters = new HashSet<>();    // Set: nincs ismétlés benne
        for (char c: arr) {
            // System.out.println(c);  ->  a
                                        // p
                                        // p
                                        // l
                                        // e
            if (isEnglishChar(c)) {
                characters.add(c);
                // System.out.println(characters);  // [a]
                                                    // [p, a]
                                                    // [p, a]          -> Set miatt
                                                    // [p, a, l]
                                                    // [p, a, e, l]
            }
        }
        return characters.size();

    }

    private boolean isEnglishChar(char c) {         // angol abc betűje-e
        return 'a' <= c && c <= 'z';
    }


    // 3.
    public int countUniqueLetter(String word) {
        Set<Character> result = new HashSet<>();
        for (char c: word.toLowerCase().toCharArray()) {
            if ( isEnglishChar(c) ) {
                result.add(c);
            }
        }
        return result.size();
    }


    // 4.
    public int countUniqueCharacter(String word) {
        if ( word == null) {
            throw new IllegalArgumentException("Letter is null.");
        }
        Map<Character, Integer> counter = new HashMap<>();          // Map: kulcs, érték
        word = word.toLowerCase().replaceAll("[\\W\\d\\s]", ""); // par-nek ad új értéket, nem túl jó
                        // reguláris kif: kicseréli az összes nem betűt, számjegyet, szóközt -> üres Stringre
                        // W = nonWord, d = digit, s = whiteSpace
        char[] stringArray = word.toCharArray();    // par-t karaktertömbbé alakítja
        for (char c: stringArray) {
            if ( isEnglishChar(c) ) {
                counter.put(c, 1);
                // System.out.println(counter);     // {}
                                                    // {a=1}
                                                    // {p=1, a=1}
                                                    // {p=1, a=1}
                                                    // {p=1, a=1, l=1}
                                                    // {p=1, a=1, e=1, l=1}
            }
        }
        return counter.size();
    }


    public static void main(String[] args) {
        LetterCounter lc = new LetterCounter(97, 122);
        System.out.println(lc.countLetter("apple"));            // 4
        System.out.println(lc.countCharacter("apple"));         // 4
        System.out.println(lc.countUniqueLetter("apple"));      // 4
        System.out.println(lc.countUniqueCharacter("apple"));   // 4

    }


}


