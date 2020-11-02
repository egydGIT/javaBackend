package classstructureattributes;

import java.util.Scanner;
import java.util.concurrent.Callable;

public class ClientMain {
    public static void main(String[] args) {
        System.out.println("Please give your details!");
        System.out.println("What is your name?");

        Scanner scanner = new Scanner(System.in);
        Client client = new Client();

        client.name = scanner.nextLine();

        System.out.println("Year of birth?");
        client.yearOfBirth = scanner.nextInt();

        client.address = scanner.nextLine();
        System.out.println("What is your address?");
        client.address = scanner.nextLine();

        System.out.println("Name: " + client.name);
        System.out.println("Birth: " + client.yearOfBirth);
        System.out.println("Address: " + client.address );

    }
}
