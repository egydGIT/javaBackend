package ioreadstring.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionManagerTest {

    TransactionManager tm = new TransactionManager();


    @Test
    void testDataFromAccountFileMy() {
        assertEquals(0, tm.getAccounts().size());

        tm.dataFromAccountFileMy("src/test/resources/accounts.txt");

        assertEquals(2, tm.getAccounts().size());
        assertEquals("11111111-00000000-11111111", tm.getAccounts().get(0).getAccountNumber());
    }


    TransactionManager tm2 = new TransactionManager();

    @Test
    public void testUploadAccounts() {
        assertEquals(0, tm.getAccounts().size());

        tm.uploadListFromFile("src/test/resources/accounts2.txt");

        assertEquals(5, tm.getAccounts().size());
        assertEquals("Jack Doe", tm.getAccounts().get(3).getName());
        assertEquals(234050200, tm.getAccounts().get(1).getBalance(), 0.0000001);

    }

    @Test
    public void makeTransactionsTest() {
        tm.uploadListFromFile("src/test/resources/accounts2.txt");

        tm.makeTransactions("src/test/resources/transactions2.txt");

        assertEquals(1201000, tm.getAccounts().get(0).getBalance(), 0.0000001);
        assertEquals(721220, tm.getAccounts().get(3).getBalance(), 0.00001);

    }

}