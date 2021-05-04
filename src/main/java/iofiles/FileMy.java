package iofiles;

import abreast.filemy.FilesMy;
import ioreaderclasspath.CountryStatistics;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileMy {

    Path file = Path.of("fileName.txt");
    // 1. Fájl -> karakter BE
    public String read1() {
        try {
            String content = Files.readString(file, StandardCharsets.UTF_8);
            return content;
        } catch (IOException e) {
            throw new IllegalStateException("Cant read file.", e);
        }
    }

    public List<String> read2() {
        try {
            List<String> lines = Files.readAllLines(file, Charset.forName("ISO-8859-2"));
            return lines;                                                // [one, two, three]
        } catch (IOException e) {
            throw new IllegalStateException("Cant read file.", e);
        }
    }

    // 2. Fájl <- karakter KI
    public void write1() {
        try {
            Files.writeString(file, "\nfour\nfive\n", StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new IllegalStateException("Cant write file.", e);
        }
    }

    public void write2() {
        try {
            Files.write(file, List.of("six", "seven"), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new IllegalStateException("Cant write file.", e);
        }
    }

    // 4. Fájl -> Karakter BE darabokban  - try-w-r
    public void readWithPuffer() {
        try (BufferedReader br = Files.newBufferedReader(file)){
            //  new BufferedReader(new FileReader("rc/main/java/abreast/filemy/fileName.txt"));
            // Fájl   ->   FileReader -> BufferedReader
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cant read file.", e);
        }
    }

    // 5. Fájl <- Karakter Ki darabokban   - try-w-r
    public void writeWithPuffer() {
        List<String> words = List.of("Egy", "Kettő", "Három");
        try (BufferedWriter bw = Files.newBufferedWriter(file, StandardOpenOption.APPEND)){
            //  new BufferedWriter(new FileWriter("rc/main/java/abreast/filemy/fileName.txt"));
            // Fájl   <-   FileWriter <- BufferedWriter
            for (String w : words) {
                bw.write(w + "\n");
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cant write file.", e);
        }
    }

    // 6. Fájl <- Több típus Ki darabokban   - try-w-r
    public void printTypesWithPuffer() {
        List<String> words = List.of("Egy", "Kettő", "Három");
        try (PrintWriter pw = new PrintWriter ( Files.newBufferedWriter(file))) {
            // Fájl   <-   FileWriter <- BufferedWriter <- PrintWriter
            for (String w : words) {
                pw.print(w + ": ");
                pw.println(w.length());
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cant write file.", e);
        }
    }

    // 7. Fájl <- Több típus Ki darabokban   - try-w-r
    public void writeStringOrFile( Writer writer) {
        List<String> words = List.of("Egy", "Kettő", "Három");
        PrintWriter pw = new PrintWriter(writer);
        //  ... <- PrintWriter
        for (String w : words) {
            pw.print(w + ": ");
            pw.println(w.length());
        }
    }

    /*
    // 7.
    Path file = Path.of("fileName.txt");

        try (BufferedWriter bw = Files.newBufferedWriter( file)){
        // Fájl   <-   FileWriter <- BufferedWriter  <- ... / PrintWriter

        new filesMy().writeStringOrFile(bw);

    } catch (IOException e) {
        throw new IllegalStateException("Cant write file.", e);
    }


        try (StringWriter sw = new StringWriter()){
        // Memória    <-   StringWriter  <- ... / PrintWriter

        new filesMy().writeStringOrFile(sw);
        System.out.println(sw.toString());

    } catch (IOException e) {
        throw new IllegalStateException("Cant write file.", e);
    }

 */

//----------------------------------------------------------------------------------

        // 3.a  Fájl <- Byte KI
        Path fileData = Path.of("fileData.dat");
        public void writeByte() {
            try {
                Files.write(fileData, new byte[] {97, 98, 99});
            } catch (IOException e) {
                throw new IllegalStateException("Cant write file.", e);
            }
        }

        // 3.b  Fájl -> Byte BE
        public byte[] readByte() {
            try {
                byte[] bytes = Files.readAllBytes(fileData);
                return bytes;
            } catch (IOException e) {
                throw new IllegalStateException("Cant read file.", e);
            }
        }

        // 8. Fájl (bináris)  -> Byte BE InputStream
        public void readByteWithInputSteam() {
            try (InputStream is = new BufferedInputStream ( Files.newInputStream(fileData))) {

                // Fájl (bináris)   ->   FileInputStream -> BufferedInputStream
                // byte[] bytes = is.readAllBytes();        // egyben olvassa be
                byte[] buffer = new byte[1000];
                int size;
                while ((size = is.read(buffer)) > 0) {      // darabokban
                    System.out.println(Arrays.toString(buffer));
                }
            } catch (IOException e) {
                throw new IllegalStateException("Cant read file.", e);
            }
        }

        // 10. Fájl  <-  Byte KI OutputStream
        public void writeByteWithOutputStream() {
            try (BufferedOutputStream os = new BufferedOutputStream(Files.newOutputStream(fileData))) {
                // Fájl:  <-  File OutputStream  <- BufferedOutputStream
                for (int i = 0; i < 1000; i++) {
                    os.write("abcd".getBytes());
                }
            } catch (IOException e) {
                throw new IllegalStateException("Cant write file.", e);
            }
        }

        // 11.a  Fájl  <-  Byte KI DataOutputStream  <-  Több típus
        public void writeManyTypesWithDataOutputStream() {
            try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream( Files.newOutputStream( fileData)))) {
                // Fájl:  <-  File OutputStream  <- BufferedOutputStream  <-  DataOutputStream
                dos.writeUTF("String");
                dos.writeInt(200_000);
            } catch (IOException e) {
                throw new IllegalStateException("Cant write file.", e);
            }
        }

        // 11.b Fájl  ->  Byte BE DataInputStream  ->  Több típus
        public void writeManyTypesWithDataInputStream() {
            try (DataInputStream dis = new DataInputStream( new BufferedInputStream(Files.newInputStream( fileData)))) {
            // Fájl:  ->  File InputStream  -> BufferedInputStream  ->  DataInputStream
                String name = dis.readUTF();
                int salary = dis.readInt();
            } catch (IOException e) {
                throw new IllegalStateException("Cant read file.", e);
            }
        }

        //----------------------------------------------------------------------------------
        // 12. ZIP Fájl:  <-  byte KI
        Path fileZip = Path.of("data.zip");
        public void writeToZip() {
            try (ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(Files.newOutputStream(fileZip)))) {
            // ZIP Fájl: <-  File OutputStream  <- BufferedOutputStream  <-  ZipOutputStream
                zos.putNextEntry(new ZipEntry("data.dat"));
                for (int i = 0; i < 1000; i++) {
                    zos.write("abcd".getBytes());
            }
            } catch (IOException e) {
                throw new IllegalStateException("Cant write file.", e);
            }
        }

//----------------------------------------------------------------------------------
        // Konvertálás
        // Fájl (bináris)  ->  InputStream   ->  InputStreamReader   ->  (karakterek)
        // Fájl (bináris)  <-  OutputStream  <- BufferedOutputStream  <-  OutputStreamWriter  <-  (karakterek)  .write
        // Fájl (bináris)  <-  OutputStream  <- BufferedOutputStream  <-     PrintStream      <-  (karakterek)  .println




        //----------------------------------------------------------------------------------
        // 9. ClassPath: src/main/resorces -> target/classes
        public void readFromClassPath(String fileName) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(
                    CountryStatistics.class.getResourceAsStream("/" + fileName)))) {
        // ClassPath: -> InputStream 		-> InputStreamReader    -> BufferedReader =(ClassName.class.gEAS())
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                throw new IllegalStateException("Can not read file.", e);
            }
        }


        public static void main(String[] args) {

            FilesMy filesMy = new FilesMy();
            // 1.
            System.out.println(filesMy.read1());
            System.out.println(filesMy.read2());
            // 2.
            filesMy.write1();
            filesMy.write2();
            // 3.
            filesMy.writeByte();
            System.out.println(Arrays.toString(filesMy.readByte()));
            // 4.
            filesMy.readWithPuffer();
            // 5.
            filesMy.writeWithPuffer();
            // 6.
            filesMy.printTypesWithPuffer();
            // 7.
            Path file = Path.of("src/main/java/abreast/filemy/fileName.txt");
            try (BufferedWriter bw = Files.newBufferedWriter(file, StandardOpenOption.APPEND)){
                // Fájl   <-   FileWriter <- BufferedWriter  <- ... / PrintWriter
                filesMy.writeStringOrFile(bw);
            } catch (IOException e) {
                throw new IllegalStateException("Cant write file.", e);
            }

            try (StringWriter sw = new StringWriter()){
            // Memória    <-   StringWriter  <- ... / PrintWriter
                filesMy.writeStringOrFile(sw);
                System.out.println("");
                System.out.println(sw.toString());
            } catch (IOException e) {
                throw new IllegalStateException("Cant write file.", e);
            }
        }


}


