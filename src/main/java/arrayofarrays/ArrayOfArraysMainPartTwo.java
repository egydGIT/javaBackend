package arrayofarrays;

import java.util.Arrays;

public class ArrayOfArraysMainPartTwo {

    public void printArrayOfArrays(int[][] a) {
        for (int i[] : a) {
            for (int j : i) {
                if (j < 10) {
                    System.out.print("  ");
                } else if (j < 100) {
                    System.out.print(" ");
                }
                System.out.print(j);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public int[][] multiplicationTable(int size) {
        int[][] multiplicationTable = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                multiplicationTable[i][j] = (i + 1) * (j + 1);
            }
        }
        return multiplicationTable;
    }

    public int[][] triangularMatrix(int size) {
        int[][] triangularMatrix = new int[size][];
        for (int i = 0; i < triangularMatrix.length; i++) {
            triangularMatrix[i] = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                triangularMatrix[i][j] = i;
            }
        }
        return triangularMatrix;
    }

    public int[][] getValues() {
        int[][] values = new int[12][];
        int[] numberOfDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 0; i < numberOfDays.length; i++) {
            values[i] = new int[numberOfDays[i]];
        }
        return values;
    }


    public static void main(String[] args) {
        int [][] arraysInArray = { {1, 2, 3, 4}, {2, 2, 2, 2}, {0, 1, 0, 1, 0, 1, 0, 1}, {2, 4, 8, 16, 32, 64} };       // printArrayOfArrays version 1.0
        System.out.println("Tömbök tömbje: " + Arrays.deepToString(arraysInArray));
        System.out.println("Első sor: " + Arrays.deepToString(Arrays.copyOfRange(arraysInArray, 0, 1)));
        System.out.println("Második sor: " + Arrays.deepToString(Arrays.copyOfRange(arraysInArray, 1, 2)));
        System.out.println("Harmadik sor: " + Arrays.deepToString(Arrays.copyOfRange(arraysInArray, 2, 3)));
        System.out.println("Negyedik sor: " + Arrays.deepToString(Arrays.copyOfRange(arraysInArray, 3, 4)));

        ArrayOfArraysMainPartTwo arrayOfArraysMainPartTwo = new ArrayOfArraysMainPartTwo();


        System.out.println("Multiplication table");
        arrayOfArraysMainPartTwo.printArrayOfArrays(arrayOfArraysMainPartTwo.multiplicationTable(10));

        System.out.println("Triangular matrix");
        arrayOfArraysMainPartTwo.printArrayOfArrays(arrayOfArraysMainPartTwo.triangularMatrix(3));

        System.out.println("Values per days");
        arrayOfArraysMainPartTwo.printArrayOfArrays(arrayOfArraysMainPartTwo.getValues());


    }

}
