/*
Junior
Készítsd el a week12d03.NumberStat osztályt melyben legyen egy metódus, ami paraméterül vár egy egész számokból álló listát.
Add vissza azt a számot amelyik pontosan egyszer szerepel a listában. Ha több ilyen szám van akkor a kisebbet!
Ellenőrizd, hogy olyan listát fogadunk el, ami legalább 1 elemű, ha a lista nem ilyen, dobj kivételt!
pl: {1,1,5,3,4,5,6,5,6,4,1,6,5,4} A megoldás: 3

Bónusz: Módosítsd az osztályt. Legyen egy egész számokból álló lista attribútuma.
A fent megírt metódus ezen a listán dolgozzon. A lista elemeit fájlból töltsük fel.
A file úgy néz ki, hogy egy sorban három szám van vesszővel elválasztva. Tehát:

1,1,4
2,3,5
2,2,5
 */

package week12d03;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberStat {

    private List<Integer> numbers = new ArrayList<>();

    public void readFromFile(String fileName) {                     // file beolvasás
        Path file = Path.of(fileName);                              // Path objektum létrehozása

        try (BufferedReader br = Files.newBufferedReader(file)) {   // szövegfájl beolvasása, átadjuk neki a fájlt
                                                                    // try-with-resources szerk. -> lezárja a fájlt
            String line;                                            // pufferelten beolvasott egész sort line változóba
            while ((line = br.readLine()) != null) {                // amíg képes sort beolvasni
                                                                    // beolvasott sorban szereplő adatot kell feldolgozni
                String[] temp = line.split(",");              // vessző mentén vágja, elemeket tömbbe teszi (sor hossza nem számít)
                addNumbers(temp);                                   // temp tömb elemeit beleteszzük a numbers listába -> külön met.
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("File not found.", e);
        }
    }

    private void addNumbers(String[] temp) {
        for (String s: temp) {                   // végigmegy a tömbbön
            numbers.add(Integer.parseInt(s));    // parseInt: fájlban lévő számot szövegként olvassuk be -> vissza kell alakítani számmá
        }                                        // majd a számokat beleteszzük a numbers Integer listába
    }

    private int findSmallestUnique() {
        if ( numbers.size() == 0 ) {                             // ha nincs elem a listában
            throw new IllegalStateException("Attribute is empty.");
        }
        if ( numbers.size() == 1 ) {                            // ha egy elem van a listában: akkor ez tulképp a keresett szám
            return numbers.get(0);
        }

        List<Integer> sortedNumbers = new ArrayList<>(numbers);   // új listába másoljuk a beolvasott listát
        Collections.sort(sortedNumbers);                          // sorba rendezzük

        if ( numbers.get(0) != numbers.get(1)) {                 // két elemű lista: és a két elem különbözik
            return numbers.get(0);                               // akkor a 0. indexen van a kisebb (a rendezés miatt)
        }

        for ( int i = 1; i < sortedNumbers.size()-1; i++ ) {
            // ha a szám előtt és után ugyanaz a szám áll -> biztos nem egyedi a szám (elsőt és utólsót külön kell kezelni)
            // ha a vizsgált szám nem egyenlő az előtte és utána állóval, akkor találtunk egy elemet, ami egyedi
            if ( sortedNumbers.get(i) != sortedNumbers.get(i-1) && sortedNumbers.get(i) != sortedNumbers.get(i+1)) {
                return sortedNumbers.get(i);
            }
        }

        if (numbers.get(numbers.size()-1) != numbers.get(numbers.size()-2)) {  // ha utólsó elem nem egyenlő az utólsó előttivel
            return sortedNumbers.get(numbers.size()-1);                         // akkor visszaadja az utólsót, mint legkisebb egyedi
                                                                                // (kvázi egyben a legnagyobb)
        }

        throw new IllegalStateException("no unique number");
    }


    private int findSmallestUniqueWithFrequency() {                     // Collections.frequency met.-sal
        if ( numbers.size() == 0 ) {
            throw new IllegalStateException("Attribute is empty.");
        }
        if ( numbers.size() == 1 ) {
            return numbers.get(0);
        }

        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);

        for (int i : sortedNumbers) {
            if (Collections.frequency(sortedNumbers, i) == 1) {     // par: lista, elem -> megmondja listában az elem hányszor fordul elő
                return i;
            }
        }

        throw new IllegalStateException("no unique number");
    }

    public List<Integer> getNumbers() {
        return numbers;
    }


    public static void main(String[] args) {
        NumberStat ns = new NumberStat();
        ns.readFromFile("src/main/resources/numberstat.txt");
        System.out.println(ns.getNumbers());                            // [1, 1, 4, 2, 3, 5, 2, 2, 5]
        System.out.println(ns.findSmallestUnique());                    // 3
        System.out.println(ns.findSmallestUniqueWithFrequency());       // 3

    }
}
