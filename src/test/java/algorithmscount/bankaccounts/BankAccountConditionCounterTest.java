package algorithmscount.bankaccounts;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BankAccountConditionCounterTest {

    @Test
    public void createBankAccount() {
        BankAccount bankAccount = new BankAccount("John Doe", "1234", 1000);
        assertEquals("John Doe", bankAccount.getNameOfOwner());
        assertEquals("1234", bankAccount.getAccountNumber());
        assertEquals(1000, bankAccount.getBalance());
    }

    @Test
    public void testCountWithBalanceGreaterThan() {
        List<BankAccount> bankAccounts = Arrays.asList(
                new BankAccount("John Doe", "123", 100),
                new BankAccount("Jane Doe", "123", 200),
                new BankAccount("Joe Doe", "123", 300),
                new BankAccount("Jennifer Doe", "123", 400));

        assertEquals(3, new BankAccountConditionCounter().countBankAccountBalanceLargerThan(bankAccounts, 100));
        assertEquals(0, new BankAccountConditionCounter().countBankAccountBalanceLargerThan(bankAccounts, 400));
    }

}