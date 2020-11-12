package arrayofarrays;

public class ArrayOfArraysMain {
/*
    int [][] multiplicationTabla(int size) {

    }
*/

    public static void main(String[] args) {
        int [][] multiplicationTable = new int[10][11];

        for (int k = 1; k <= 10; k++)  {
            System.out.println("A " + k + " szorzótábla: ");
            for ( int i = 1; i <= 10; i++) {
                System.out.print((multiplicationTable [k][i] = k * i) + " "); ;
            }
            System.out.println();
        }

    }

}
