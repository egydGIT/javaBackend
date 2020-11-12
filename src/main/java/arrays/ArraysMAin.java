package arrays;

import java.util.Arrays;
import java.util.List;

public class ArraysMAin {
    public String numberOfDaysAsString() {
        int[] numberOfDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return Arrays.toString(numberOfDays);
    }

    public List<String> daysOfWeek() {
        List<String> daysOfWeek = Arrays.asList("Hétfő", "Kedd", "Szerda", "Csütörtök", "Péntek", "Szombat", "Vasárnap");
        return daysOfWeek;
    }

    public String multiplicationTableAsString(int size) {
        int[][] multiplicationTable = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                multiplicationTable[i][j] = (i + 1) * (j + 1);
            }
        }
        return Arrays.deepToString(multiplicationTable);
    }

    public boolean sameTempValues(double[] day, double[] anotherDay) {
        return Arrays.equals(day, anotherDay);
    }

    public boolean wonLottery(int[] winner, int[] stake) {
        int[] Winner = new int[6];
        int[] MayBeWinner = new int[6];
        Arrays.sort(Winner);
        Arrays.sort(MayBeWinner);
        return Arrays.equals(Winner, MayBeWinner);
    }

    public static void main(String[] args) {
        ArraysMAin arraysMain = new ArraysMAin();

        System.out.println(arraysMain.numberOfDaysAsString());

        System.out.println(arraysMain.daysOfWeek());

        System.out.println(arraysMain.multiplicationTableAsString(10));

        System.out.println(arraysMain.sameTempValues(new double[] {25, 27.9, 25.4}, new double[] {26.2, 27, 25.8}));

        int[] Winner = {2, 28, 3, 21, 87, 7};
        int[] MayBeWinner = {21, 28, 7, 87, 2, 3};
        System.out.println("Ön nyert? " + arraysMain.wonLottery(Winner, MayBeWinner));


    }
}
