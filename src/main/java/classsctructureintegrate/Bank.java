package classsctructureintegrate;

import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BankAccount bankaccount = new BankAccount("Tóth Kálmán","10073217-12000098-67341590", 103400);
        BankAccount bankaccount2 = new BankAccount("Szabó Attila","10073217-02589003-25890036", 543200);

        System.out.println(bankaccount.getInfo());
        System.out.println(bankaccount2.getInfo());

        System.out.println("");
        System.out.println("Kinek szeretne befizetni?");
        String owner = scanner.nextLine();

        System.out.println("Mekkora összeget?");
        int amount = scanner.nextInt();

        bankaccount.deposit(amount);
        System.out.println(bankaccount.getInfo());

        bankaccount2.deposit(amount);
        System.out.println(bankaccount2.getInfo());

/*
        System.out.println("");

        System.out.println("Kitől szeretne kivenni?");
        String owner = scanner.nextLine();

        System.out.println("Mekkora összeget?");
        int amount = scanner.nextInt();

        bankaccount.deposit(amount);
        System.out.println(bankaccount.getInfo());

        bankaccount2.deposit(amount);
        System.out.println(bankaccount2.getInfo());
*/

    }
}
