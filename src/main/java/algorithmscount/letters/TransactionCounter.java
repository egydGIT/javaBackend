package algorithmscount.letters;

import java.util.ArrayList;
import java.util.List;

public class TransactionCounter {
    public int transactionsLowerThan (List<Transaction> transactions, int amount) {
        int counter = 0;
        for (Transaction transaction: transactions) {
            if (transaction.getAmount() < amount) {
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        Transaction transaction1 = new Transaction("123", TransactionType.CREDIT, 8_500);
        Transaction transaction2 = new Transaction("456", TransactionType.DEBIT, 7_500);
        Transaction transaction3 = new Transaction("789", TransactionType.CREDIT, 9_780);

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);

        System.out.println(new TransactionCounter().transactionsLowerThan(transactions, 9_000));
    }
}
