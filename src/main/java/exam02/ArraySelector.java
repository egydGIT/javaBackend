package exam02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraySelector {

    /*
    Tömbök
    Írj egy olyan metódust az ArraySelector osztályban, mely egy kapott tömbből minden második elemet kiválogat,
    és egy szövegként összerak, szögletes zárójelek között!

    A páros megállapítása index szerint működik.
    Azaz az első, nulla indexű elem páros, a második, azaz egyes indexű elem páratlan, stb.

    Ha nulla elemű a tömb, akkor üres stringet adjon vissza!
     */


    public String selectEvens(int[] array) {
        List<Integer> filteredArray = new ArrayList<>();      // szűrés listába
        if (array == null) {
            return new ArrayList<>().toString();                // ez üres lista, nem üres String...
        }
        for (int i = 0; i < array.length; i+=2) {
            filteredArray.add(array[i]);
        }
        return filteredArray.toString();
    }

    public static void main(String[] args) {
        ArraySelector arraySelector = new ArraySelector();
        int [] array = { 1, 2, 3, 4, 5};
        System.out.println(arraySelector.selectEvens(array));


    }

}