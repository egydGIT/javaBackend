package exceptionclass.bank;

import java.util.List;

public class Bank {

    private List<Account> accounts;

    public Bank(List<Account> accounts) {
        if (accounts == null) {
            throw new IllegalArgumentException("Amounts is null.");
        }
        this.accounts = accounts;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    // solution
    /*

    public void payment(String accountNumber, double amount) throws InvalidBankOperationException {
        Account account = get(accountNumber);
        account.subtract(amount);
    }

    public void deposit(String accountNumber, double amount) throws InvalidBankOperationException {
        Account account = get(accountNumber);
        account.deposit(amount);
    }

    private Account get(String accountNumber) throws InvalidBankOperationException {
        for (Account account: accounts) {
            if (accountNumber.equals(account.getAccountNumber())) {
                return account;
            }
        }
        throw new InvalidBankOperationException(ErrorCode.INVALID_ACCOUNTNUMBER);
    }
     */
}
