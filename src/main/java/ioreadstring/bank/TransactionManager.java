package ioreadstring.bank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {

    BankAccount bankAccount;
    List<BankAccount> accounts = new ArrayList<>();

    public void dataFromAccountFileMy(String filePath) {
        Path file = Path.of(filePath);
        try {
            List<String> linesFromFile = Files.readAllLines(file);
            for (String s: linesFromFile) {
                String[] dataFromLines = s.split(",");
                BankAccount b1 = new BankAccount(dataFromLines[0], Integer.parseInt(dataFromLines[1]));
                accounts.add(b1);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("File not found: " + e);
        }
    }

    public void uploadListFromFile(String filePath){
        Path file = Path.of(filePath);
        try {
            List<String> accountsFromFile = Files.readAllLines(file);
            for(String s: accountsFromFile){
                String[] temp = s.split(";");
                BankAccount ba = new BankAccount(temp[0],temp[1],Integer.parseInt(temp[2]));
                accounts.add(ba);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't open file",e);
        }
    }

    public void dataFromTransactionFileMy(String filePath) {
        Path file = Path.of(filePath);
        try {
            List<String> linesFromFile = Files.readAllLines(file);                  // külön metódusba kellene kiszervezni pár dolgot
            for(String s: linesFromFile) {
                String[] dataFromLines = s.split(",");
                for (BankAccount b: accounts) {
                    if (dataFromLines[0].equals(b.getAccountNumber())) {
                        if (dataFromLines[2].equals("0")) {     // tömb 2. eleme a bevétel
                            //b.getBalance() += Integer.parseInt(dataFromLines[1]);
                            b.addAmount(Integer.parseInt(dataFromLines[1]));
                        }
                        if (dataFromLines[1].equals("0")) {     // tömb 3. eleme a kiadás
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

    public void makeTransactions(String filePath){
        Path transactions = Path.of(filePath);
        try {
            List<String> transactionsFromFile = Files.readAllLines(transactions);
            for(String s : transactionsFromFile){
                String[] temp = s.split(";");
                for(BankAccount b : accounts){
                    if(temp[0].equals(b.getAccountNumber())){
                        b.setBalance(Integer.parseInt(temp[1]));
                    }
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't open file",e);
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
        transactionManager.dataFromAccountFileMy("src/test/resources/accounts.txt");
        System.out.println(transactionManager.getAccounts().toString());
        //        [BankAccount{accountNumber='11111111-00000000-11111111', balance=250000},
        //        BankAccount{accountNumber='11111111-00000000-22222222', balance=470000}]
        transactionManager.dataFromTransactionFileMy("src/test/resources/transactions.txt");
        System.out.println(transactionManager.getAccounts().toString());
        //        [BankAccount{accountNumber='11111111-00000000-11111111', balance=203000},
        //        BankAccount{accountNumber='11111111-00000000-22222222', balance=482000}]

    }
}
