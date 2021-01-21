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
            List<String> linesFromFile = Files.readAllLines(file);
            for(String s: linesFromFile) {
                String[] dataFromLines = s.split(", ");
                for (BankAccount b: accounts) {
                    if (dataFromLines[0].equals(b.getAccountNumber())) {
                        if (dataFromLines[1].charAt(0) == '+') {
                            int plusAmount = Integer.parseInt(dataFromLines[1].substring(1));
                            //b.getBalance() += plusAmount;
                        }
                        if (dataFromLines[1].charAt(0) == '-') {
                            //b.getBalance() -= Integer.parseInt(dataFromLines[1].substring(1));
                        }
                    }
                }
            }

        } catch (IOException e) {
            throw new IllegalArgumentException("File not found: " + filePath);
        }
    }


    public static void main(String[] args) {
        TransactionManager transactionManager = new TransactionManager();
        transactionManager.dataFromAccountFile("transactions.txt");


    }
}
