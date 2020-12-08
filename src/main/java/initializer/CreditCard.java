package initializer;

public class CreditCard {
    private long balance;
    private long amount;
    private Currency currency;

    public CreditCard(long balance, Currency currency) {
        this.balance = balance;
        this.currency = currency;
    }

    public CreditCard(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }
/*
    public boolean payment(long amount, Currency currency) {

    }

    public boolean payment(long amount) {

    }

 */
}
