package array;

import java.util.List;

public class ArrayHandler {

    int itemToFind;

    boolean contaiins (int[] source, int itemToFind ) {
        for ( int item : source ) {
            if (itemToFind == item) {
                return true;
            }
        }
        return false;
    }

    int find (int[] source, int itemToFind ) {
        for ( int i = 0; i < source.length; i++ ) {
            if ( source[i] == itemToFind ) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayHandler array = new ArrayHandler();

        int [] source = new int [4];
        source[0] = 1;
        source[1] = 5;
        source[2] = 7;
        source[3] = 6;

        System.out.println("Tömb hossza: " + source.length);
        System.out.println("3. elem tartalma: " + source[3]);
        System.out.println();

        System.out.println("Tartalmazza a 6-ot: " + array.contaiins(source, 6));
        System.out.println("Tartalmazza a 9-et: " + array.contaiins(source, 9));
        System.out.println();

        System.out.println("Hanyadik elem a 6: " + array.find(source, 6 ) + ".");
        System.out.println("Hanyadik elem a 9: " + array.find(source, 9 ) + ".");

        System.out.println("A tömb összes eleme: ");
        for (int item : source) {
            System.out.print(item + ", ");
        }

    }

}

