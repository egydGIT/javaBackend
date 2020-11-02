package classstructureio;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        System.out.println("Please give your name!");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.println("Please give your e-mail!");
        String eMail = scanner.nextLine();

        System.out.println("Name: " + name);
        System.out.println("E-mail: " + eMail);

    }
}
