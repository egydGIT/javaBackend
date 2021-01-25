package algorithmssum.transactions;

import java.util.List;

public class TransactionSumCalculator {

    int sumAmountOfCreditEntries(List<Transaction> transactions) {
        int sum = 0;
        for (Transaction transaction: transactions) {
            if (transaction.isCredit()) {
                sum += transaction.getAmount();
            }
            if (transaction.isDebit()) {
                sum -= transaction.getAmount();
            }
        }
        return sum;
    }

}
