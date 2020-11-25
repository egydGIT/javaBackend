package numbers;

import java.util.Scanner;

public class CircleMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add meg a kör átmérőjét! ");
        int answerDiameter1 = scanner.nextInt();

        System.out.println("A kör kerölete: " + new Circle(answerDiameter1).perimeter() + " cm");
        System.out.println("A kör területe: " + new Circle(answerDiameter1).area() + " cm2");

        System.out.println("");
        System.out.println("Add meg a 2. kör átmérőjét! ");
        int answerDiameter2 = scanner.nextInt();

        System.out.println("A 2. kör kerölete: " + new Circle(answerDiameter2).perimeter() + " cm");
        System.out.println("A 2. kör területe: " + new Circle(answerDiameter2).area() + " cm2");
    }
}
