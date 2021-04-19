package iozip.transactions;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class TransactionFileManager {

    private List<Transaction> transactions = new ArrayList<>();

    public void saveTransactions(Path file, List<Transaction> transactions) {
        try (ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(Files.newOutputStream(file)))) {
            for (Transaction t: transactions) {
                String actualFilename = Long.toString(t.getId());
                zos.putNextEntry(new ZipEntry(actualFilename));
                String content = t.getTime().toString() + "\n" + t.getAccount() + "\n" + Double.toString(t.getAmount());
                zos.write(content.getBytes());
                zos.closeEntry();
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can not write file", e);
        }
    }

    public List<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }
}
