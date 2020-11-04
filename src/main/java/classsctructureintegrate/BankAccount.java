package classsctructureintegrate;

import javax.sound.midi.Soundbank;

public class BankAccount {
    private String accountNumber;
    private String owner;
    private int balance;

    public BankAccount(String owner, String accountNumber, int balance) {
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(int amount) {
        balance = balance + amount;
    }

    public void withraw(int amount) {
        balance = balance - amount;
    }

    public String getInfo() {
        return owner + " (" + accountNumber + ") : " + balance + " Ft";
    }

}



// System.out.println(owner + " (" + accountNumber + ") : " + balance + " Ft");