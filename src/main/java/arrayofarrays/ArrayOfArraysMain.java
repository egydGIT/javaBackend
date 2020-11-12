package arrayofarrays;

import java.util.Scanner;

public class ArrayOfArraysMain {
/*
    int [][] multiplicationTabla(int size) {
        this.size = size;
    }
*/




    public static void main(String[] args) {
        int [][] multiplicationTable = new int[11][12];
/*
        for (int k = 1; k <= 11; k++)  {                                        // Szorzótábla fejléccel ciklusból (önálló munka!!)
            System.out.println("A " + k + " szorzótábla: ");                    // Vmiért túlfut, azt még meg kell nézni.
            for ( int i = 1; i <= 10; i++) {
                System.out.print((multiplicationTable [k][i] = k * i) + " "); ;
            }
            System.out.println();
            System.out.println();
        }
*/

        for (int k = 1; k <= 11; k++) {                                          // Szorzótábla négyzethálós ábrázolásban
            for (int i = 1; i <= 10; i++) {                                      // Vmi a végével ennek is van...
                multiplicationTable[k][i] = k * i;
                if (k * i < 10 ){
                    System.out.print((multiplicationTable[k][i] = k * i) + "  ");
                } else if (k * i < 100) {
                    System.out.print((multiplicationTable[k][i] = k * i) + " ");
                }
            }
            System.out.println();
        }










         /*
        Scanner scanner = new Scanner();
        System.out.println("Hanyas szorzótábla: ");
        int k = scanner.nextInt();

         */

    }

}
