package ioreadstring.bank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {

    BankAccount bankAccount;
    List<BankAccount> accounts = new ArrayList<>();

    public void dataFromAccountFile(String filePath) {
        Path file = Path.of(filePath);
        try {
            List<String> linesFromFile = Files.readAllLines(file);
            for (String s: linesFromFile) {
                String[] dataFromLines = s.split(", ");
                BankAccount b1 = new BankAccount(dataFromLines[0], Integer.parseInt(dataFromLines[1]));
                accounts.add(b1);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("File not found: " + filePath);
        }
    }

    public void dataFromTransactionFile(String filePath) {
        Path file = Path.of(filePath);
        try {
            List<String> linesFromFile = Files.readAllLines(file);                  // külön metódusba kellene kiszervezni pár dolgot
            for(String s: linesFromFile) {
                String[] dataFromLines = s.split(", ");
                for (BankAccount b: accounts) {
                    if (dataFromLines[0].equals(b.getAccountNumber())) {
                        if (dataFromLines[2].equals("0")) {
                            //b.getBalance() += Integer.parseInt(dataFromLines[1]);
                            b.add(Integer.parseInt(dataFromLines[1]));
                        }
                        if (dataFromLines[1].equals("0")) {
                            //b.getBalance() -= Integer.parseInt(dataFromLines[2]);
                            b.substract(Integer.parseInt(dataFromLines[2]));
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("File not found: " + filePath);
        }
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public static void main(String[] args) {
        TransactionManager transactionManager = new TransactionManager();
        transactionManager.dataFromAccountFile("accounts.txt");
        transactionManager.dataFromTransactionFile("transactions.txt");

    }
}
