package introcontrol;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adj meg öt számot és összadom! ");

        /*
        int number1 = scanner.nextInt();                                         // Egyszerűen
        int number2 = scanner.nextInt();
        int number3 = scanner.nextInt();
        int number4 = scanner.nextInt();
        int number5 = scanner.nextInt();

        System.out.println( number1 + number2 + number3 + number4 + number5 );
        */

        int sum = 0;                                                             // Ciklussal
        for ( int i = 0; i < 5; i++ ) {
            System.out.println("Add meg a " + (i + 1) + ". számot! ");
            int number = scanner.nextInt();
            sum += number;
        }
        System.out.println("Az összeg: " + sum);
    }
}
