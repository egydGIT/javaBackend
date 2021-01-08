package inheritancemethods.bankaccount;

public class DebitAccount {     // számlaegyenleg értékéig használható bankkártya

    private static final double PERCENT = 3.0;
    private static final long MIN_COST = 200;

    private String accountNumber;
    private long balance;

    public DebitAccount(String accountNumber, long balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }

    public void balanceToZero() {           // jókívánság a roszzakaróknak
        balance = 0;
    }

    public final long costOfTransaction(long amount) {
        return (amount * PERCENT / 100.0) <= MIN_COST ? MIN_COST : (long) (amount * PERCENT / 100.0);
        // tranzakció díjja: ha kisebb, mint 200, akkor 200; ha nem, akkor az elutalt összeg 3.0 %-a
    }

    public boolean transaction(long amount) {              // utalás
        long trx = amount + costOfTransaction(amount);     // elutalt összeg + tr. díjja
        if (trx <= balance) {                               // ha kettő összege kisebb, mint az egyenleg
            balance -= trx;                                 // akkor egyenlegből levonjuk
            return true;                                    // akkor teljesíthető
        }
        return false;   // ha kevesebb összeg van a számlán, mint a kettő összege, akkor nem teljesíthető a kérés
    }
}