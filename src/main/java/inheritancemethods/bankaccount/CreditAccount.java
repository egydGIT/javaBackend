package inheritancemethods.bankaccount;

public class CreditAccount extends DebitAccount {   // hitelkeret értékéig használható bankkártya

    private long overdraftLimit;                    // hitelkeret mértéke

    public CreditAccount(String accountNumber, long balance, long overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public long getOverdraftLimit() {
        return overdraftLimit;
    }

    @Override
    public boolean transaction(long amount) {                   // ősben deklarált met. felülírva
        long trx = amount + costOfTransaction(amount);
        if (trx > getBalance() + overdraftLimit) {              // akkor nem teljesül az utalás, ha a hitelkeret sem fedezi
            return false;
        }
        if (trx <= getBalance()) {                              // ha fedezi az egyenleg, akkor ősben deklarált módon
            super.transaction(amount);
        } else {                                                // ha nem fedezi az egyenleg
            long credit = amount - getBalance();                // utalni kívánt összeg - egyenleg, ami rendelkezésre áll
            balanceToZero();                                    // egyenleg ekkor 0
            overdraftLimit -= credit + costOfTransaction(amount);  // hitelkeretből biztosítjuk: amit nem fedezett az egyenleg + tr.díjja
        }
        return true;
    }
}