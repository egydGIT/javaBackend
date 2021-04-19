package iozip.names;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class EmployeeFileManager {

    public  void saveEmployees(Path fileZip, List<String> names) {
        try (ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(Files.newOutputStream(fileZip)))) {
            zos.putNextEntry(new ZipEntry("names.dat"));
            for (String name : names) {
                zos.write(name.getBytes());
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can not write file", e);
        }
    }
}
