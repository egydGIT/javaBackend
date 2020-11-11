package introcontrol;

import java.util.Scanner;

public class Qualifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kérlek addj meg egy számot! ");
        int number = scanner.nextInt();

        if ( number > 100 ) {
            System.out.println("A megadott szám nagyobb, mint 100. ");
        } else {
            System.out.println("A megadott szám kisebb, mint 100. ");
        }
    }
}
