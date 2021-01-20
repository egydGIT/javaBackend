package exceptionclass.bank;

public class Account {

    private String accountNumber;

    private double balance;

    private final double MAX_SUBTRACT = 100000;

    public Account(String accountNumber, double balance) {
        if (accountNumber == null) {
            throw new InvalidBankOperationException(ErrorCode.INVALID_ACCOUNT_NUMBER);
        }
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public double subtract(int amount) {
        // egyenleg csökkentése egy megadott értékkel
        if (balance - amount < 0) {
            throw new InvalidBankOperationException(ErrorCode.LOW_BALANCE);
        }
        if (amount > MAX_SUBTRACT || amount < 0) {
            throw new InvalidBankOperationException(ErrorCode.INVALID_AMOUNT);
        }
        balance -= amount;
        return balance;
    }

    public double deposit(int amount) {
        // egyenleg növelése egy megadott értékkel
        if (amount > MAX_SUBTRACT || amount < 0) {
            throw new InvalidBankOperationException(ErrorCode.INVALID_AMOUNT);
        }
        balance += amount;
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public double getMAX_SUBTRACT() {
        return MAX_SUBTRACT;
    }

//    public void setMaxSubtract(double maxSubtract) {
//        this.maxSubtract = maxSubtract;
//    }


}
