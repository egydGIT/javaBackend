package classstructureintegrate;

import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Mi az új számla száma?");
        String accountNumber = scanner.nextLine();

        System.out.println("Ki a tulajdonos?");
        String owner = scanner.nextLine();

        System.out.println("Mekkora összeggel nyitja?");
        int amount = scanner.nextInt();
        scanner.nextLine();

        BankAccount account1 = new BankAccount(accountNumber, owner, amount);

        System.out.println("Mi az új számla száma?");
        String accountNumber2 = scanner.nextLine();

        System.out.println("Ki a tulajdonos?");
        String owner2 = scanner.nextLine();

        System.out.println("Mekkora összeggel nyitja?");
        int amount2 = scanner.nextInt();

        BankAccount account2 = new BankAccount(accountNumber2, owner2, amount2);

        System.out.println(account1.getInfo());
        System.out.println(account2.getInfo());

        System.out.println("Mennyit szeretne befizetni az első számlára?");
        int depositAmount = scanner.nextInt();
        account1.deposit(depositAmount);

        System.out.println(account1.getInfo());

        System.out.println("Mennyit szeretne felvenni a második számláról?");
        int withdrawAmount = scanner.nextInt();
        account2.withdraw(withdrawAmount);

        System.out.println(account2.getInfo());

        System.out.println("Mennyit szeretne átutalni az első számláról a másodikra?");
        int transferAmount = scanner.nextInt();
        account1.transfer(account2, transferAmount);

        System.out.println(account1.getInfo());
        System.out.println(account2.getInfo());


//        Scanner scanner = new Scanner(System.in);
//
//        BankAccount bankaccount = new BankAccount("Tóth Kálmán","10073217-12000098-67341590", 103400);
//        BankAccount bankaccount2 = new BankAccount("Szabó Attila","10073217-02589003-25890036", 543200);
//
//        System.out.println(bankaccount.getInfo());
//        System.out.println(bankaccount2.getInfo());
//
//        System.out.println("");
//        System.out.println("Kinek szeretne befizetni?");
//        String owner = scanner.nextLine();
//
//        System.out.println("Mekkora összeget?");
//        int amount = scanner.nextInt();
//
//        bankaccount.deposit(amount);
//        System.out.println(bankaccount.getInfo());
//
//        bankaccount2.deposit(amount);
//        System.out.println(bankaccount2.getInfo());
//
//        System.out.println("");
//
//        System.out.println("Kitől szeretne kivenni?");
//        scanner.nextLine();
//        String owner2 = scanner.nextLine();
//
//        System.out.println("Mekkora összeget?");
//        int amount2 = scanner.nextInt();
//
//        bankaccount.withdraw(amount);
//        System.out.println(bankaccount.getInfo());
//
//        bankaccount2.withdraw(amount);
//        System.out.println(bankaccount2.getInfo());

    }
}
