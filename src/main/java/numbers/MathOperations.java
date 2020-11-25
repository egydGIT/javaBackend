package numbers;

import java.util.Scanner;

public class MathOperations {

    public boolean verification (int answer1) {
        if (answer1 == ((2 + 5 * 4 - 4) / 9)) {
            System.out.println("Helyes válasz! ");
            return true;
        } else {
            System.out.println("Helytelen válasz!");
            return false;
        }
    }

    double exercise = (2 + 5 * 4 - 4) / 7.0;
    public boolean verificationTwo (double answer2) {
        if ((Math.abs( exercise - answer2) < 0.0001)) {
            System.out.println("Helyes válasz! ");
            return true;
        } else {
            System.out.println("Helytelen válasz!");
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);

        System.out.println("Oldd meg az alábbi feladatot! ");
        System.out.println(" (2 + 5 * 4 - 4) / 9");
        int answer1 = scanner.nextInt();

        System.out.println(new MathOperations().verification(answer1));

        System.out.println("");
        System.out.println("Oldd meg az alábbi feladatot! ");
        System.out.println(" (2 + 5 * 4 - 4) / 7.0");
        double answer2 = scanner.nextDouble();

        System.out.println(new MathOperations().exercise);
        System.out.println(new MathOperations().verificationTwo(answer2));

    }
}
