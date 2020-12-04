package arrayofarrays;

import java.util.Scanner;

public class ArrayOfArraysMain {
    public int [][] multiplicationTable(int size) {                              // version 3.  -  ez a feladat
        int [][] multiplicationTable = new int[size+1][size+1];
        for (int k = 1; k <= size; k++) {
            for (int i = 1; i <= size; i++) {
                multiplicationTable[k][i] = k * i;
                if (k * i < 10 ){
                    System.out.print((multiplicationTable[k][i] = k * i) + "  ");
                } else if (k * i < 101) {
                    System.out.print((multiplicationTable[k][i] = k * i) + " ");
                }
            }
            System.out.println();
        }
        return multiplicationTable;
    }



    public static void main(String[] args) {
        ArrayOfArraysMain arrayOfArraysMain = new ArrayOfArraysMain();

        // Scanner scanner = new Scanner();
        // System.out.println("Hányszor hányas szorzótábla?");
        // int size = scanner.nextInt();

        arrayOfArraysMain.multiplicationTable(4);
        System.out.println();
        arrayOfArraysMain.multiplicationTable(7);


/*
        int [][] multiplicationTable = new int[11][12];
                                                                                // version 1.
        for (int k = 1; k <= 11; k++)  {                                        // Szorzótábla fejléccel ciklusból (önálló munka!!)
            System.out.println("A " + k + " szorzótábla: ");                    // Vmiért túlfut, azt még meg kell nézni.
            for ( int i = 1; i <= 10; i++) {
                System.out.print((multiplicationTable [k][i] = k * i) + " "); ;
            }
            System.out.println();
            System.out.println();
        }

                                                                                 // version 2.
        for (int k = 1; k <= 11; k++) {                                          // Szorzótábla négyzethálós ábrázolásban
            for (int i = 1; i <= 10; i++) {                                      // Vmi a végével ennek is van...
                multiplicationTable[k][i] = k * i;
                if (k * i < 10 ){
                    System.out.print((multiplicationTable[k][i] = k * i) + "  ");
                } else if (k * i < 101) {
                    System.out.print((multiplicationTable[k][i] = k * i) + " ");
                }
            }
            System.out.println();
        }
*/

    }

}
