package exam02;

import java.util.Arrays;

public class ArraySelector {

    /*
    Tömbök
    Írj egy olyan metódust az ArraySelector osztályban, mely egy kapott tömbből minden második elemet kiválogat,
    és egy szövegként összerak, szögletes zárójelek között!

    A páros megállapítása index szerint működik.
    Azaz az első, nulla indexű elem páros, a második, azaz egyes indexű elem páratlan, stb.

    Ha nulla elemű a tömb, akkor üres stringet adjon vissza!
     */

    public void selectEvens(int[] array) {
        for (int i = 0; i < array.length; i+=2) {
            System.out.println(Arrays.toString(array));   // nem tudok tömbhöz hozzáadni ciklusban
        }                                                 // ez veszi minden 2. elemét és annyiszor kiírja az eredeti tömböt
    }

    public static void main(String[] args) {
        ArraySelector arraySelector = new ArraySelector();
        arraySelector.selectEvens(new int[]{1, 2, 3});



    }

}
