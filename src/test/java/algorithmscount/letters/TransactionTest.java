package algorithmscount.bankaccounts;

import algorithmscount.Transaction;
import algorithmscount.TransactionCounter;
import algorithmscount.TransactionType;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionTest {

    @Test
    public void createTransaction() {
        Transaction transaction = new Transaction("1234", TransactionType.CREDIT, 100);
        assertEquals("1234", transaction.getAccountNumber());
        assertTrue(transaction.isCredit());
        assertFalse(transaction.isDebit());
        assertEquals(100, transaction.getAmount());
    }

    @Test
    public void testCountEntryLessThan() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("1234", TransactionType.CREDIT, 1000),
                new Transaction("1234", TransactionType.CREDIT, 2000),
                new Transaction("1234", TransactionType.CREDIT, 3000),
                new Transaction("1234", TransactionType.CREDIT, 4000)
        );

        assertEquals(1, new TransactionCounter().transactionsLowerThan(transactions, 2000));
        assertEquals(0, new TransactionCounter().transactionsLowerThan(transactions, 1000));
        assertEquals(4, new TransactionCounter().transactionsLowerThan(transactions, 10000));
    }
}