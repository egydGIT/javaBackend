package algorithmscount.bankaccounts;

import java.util.ArrayList;
import java.util.List;

public class BankAccountConditionCounter {
    public int countBankAccountBalanceLargerThan(List<BankAccount> bankAccounts, int balance) {
        int count = 0;
        for (BankAccount bankAccount: bankAccounts) {
            if (bankAccount.getBalance() > balance ) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount("Walker", "1001-2594-4690", 1_580_000);
        BankAccount bankAccount2 = new BankAccount("Daniels", "1001-5789-1023", 250_000);
        BankAccount bankAccount3 = new BankAccount("Regal", "1001-2489-0257", 8_200_000);

        List<BankAccount> bankAccounts = new ArrayList<>();

        bankAccounts.add(bankAccount1);
        bankAccounts.add(bankAccount2);
        bankAccounts.add(bankAccount3);

        System.out.println(new BankAccountConditionCounter().countBankAccountBalanceLargerThan
                (bankAccounts, 1_000_000));

    }
}
