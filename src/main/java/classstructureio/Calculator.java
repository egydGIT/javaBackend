package classstructureio;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("Give me a number!");
        Scanner scanner = new Scanner(System.in);
        int firstNumber = scanner.nextInt();

        System.out.println("Give me another number!");
        int secondNumber = scanner.nextInt();

        System.out.println(firstNumber + " + " + secondNumber);
        System.out.println(firstNumber + secondNumber);

    }
}
