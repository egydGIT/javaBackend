/*
Mai junior/mid-level feladat:
Készítsünk egy DivisorFinder nevű osztályt, melynek van egy int findDivisors(int n) metódusa.
A feladat az, hogy megnézzük a szám minden egyes számjegyére, hogy osztója-e a számnak, majd számoljuk össze őket.
Példa: a 425-ben az 5 osztója a számnak, ezért a visszatérési érték 1.
 */

package week11d01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DivisorFinder {


    public int findDivisors(int n) {
        int result = 0;
        String number = Integer.toString(n);
        for (int i = 0; i < number.length(); i++) {
            int digit = Integer.parseInt(Character.toString(number.charAt(i)));
            if( n % digit == 0 ) {
                result++;
            }
        }
        return result;
    }



    public static void main(String[] args) {
        DivisorFinder divisorFinder = new DivisorFinder();
        System.out.println(divisorFinder.findDivisors(425));        // 1
        System.out.println(divisorFinder.findDivisors(555));        // 3
        System.out.println(divisorFinder.findDivisors(424));        // 3
        // System.out.println(divisorFinder.findDivisors(404));        // ArithmeticException: / by zero


    }




}




/*
        String s = Integer.toString(n);
        StringBuilder sb = new StringBuilder("s");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        System.out.println(sb);
        return sb.toString();



        Scanner scanner = new Scanner("n").useDelimiter("");
        List<Integer> devide = new ArrayList<>();
        if (scanner.hasNextInt()) {
            devide.add(scanner.nextInt());
        }
        System.out.println(devide);
        return devide;
 */