package arrayofarrays;

import java.util.Arrays;

public class ArrayOfArraysMainPartTwo {
    /*
    public int [][] printArrayOfArrays(int [][] a) {

    }

     */

    public static void main(String[] args) {
        int [][] arraysInArray = { {1, 2, 3, 4}, {2, 2, 2, 2}, {0, 1, 0, 1, 0, 1, 0, 1}, {2, 4, 8, 16, 32, 64} };       // Version 1.0 
        System.out.println("Tömbök tömbje: " + Arrays.deepToString(arraysInArray));
        System.out.println("Első sor: " + Arrays.deepToString(Arrays.copyOfRange(arraysInArray, 0, 1)));
        System.out.println("Második sor: " + Arrays.deepToString(Arrays.copyOfRange(arraysInArray, 1, 2)));
        System.out.println("Harmadik sor: " + Arrays.deepToString(Arrays.copyOfRange(arraysInArray, 2, 3)));
        System.out.println("Negyedik sor: " + Arrays.deepToString(Arrays.copyOfRange(arraysInArray, 3, 4)));

    }

}
