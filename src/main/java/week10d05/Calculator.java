/*
Junior
Készítsünk egy Calculator nevű osztályt, melynek van egy findMinSum(int[] arr) metódusa.
A metódus feladata, hogy kiírja a legkisebb összegeket 4 számból, amiket lehetséges összerakni az arr tömb elemeiből.
Példa: ha az arr tartalma [1, 3, 5, 7, 9], akkor a minimum összeg 1+3+5+7=16.
 */

package week10d05;

import java.util.Arrays;
import java.util.List;

public class Calculator {

    public int findMinSum(int[] arr) {
        Arrays.sort(arr);
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.findMinSum(new int[]{5, 10, 7, 2, 3, 8}));        // 17
    }

}
