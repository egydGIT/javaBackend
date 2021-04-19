package iodatastream.bank;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class BankAccountManager {


    public void saveAccount(BankAccount bankAccount, Path packageName) {
        String actualName = bankAccount.getAccountNumber();
        Path fileName = packageName.resolve(actualName + ".dat");
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(fileName)))) {
           dos.writeUTF(bankAccount.getAccountNumber());
           dos.writeUTF(bankAccount.getOwner());
           dos.writeDouble(bankAccount.getBalance());
        } catch (IOException e) {
            throw new IllegalStateException("Can not write file.", e);
        }
    }
    public BankAccount loadAccount(InputStream is) {
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(is))) {
            String accountNumber = dis.readUTF();
            String owner = dis.readUTF();
            Double balance = dis.readDouble();
            return new BankAccount(accountNumber, owner, balance);
        } catch (IOException e) {
            throw new IllegalStateException("Can not read file.", e);
        }
    }


}
