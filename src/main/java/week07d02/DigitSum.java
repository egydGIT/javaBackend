package week07d02;

import java.util.Scanner;

public class DigitSum {

    /*
    Junior
    Készíts egy DigitSum osztályt és benne sumOfDigits(int x) metódus mely visszaadja a paraméterül kapott szám
    számjegyeinek összegét! pl.: 123 esetén a visszatérési érték 6.
     */

    public int sumOfDigits(int x) {
        Scanner scanner = new Scanner(Integer.toString(x)).useDelimiter("");
        int count = 0;
        while (scanner.hasNext()) {
            count += scanner.nextInt();
        }
        return count;
    }

    public static void main(String[] args) {
        DigitSum digitSum = new DigitSum();
        System.out.println("123: " + digitSum.sumOfDigits(123));
        System.out.println("333: " + digitSum.sumOfDigits(333));
        System.out.println("502: " + digitSum.sumOfDigits(502));
    }
}
