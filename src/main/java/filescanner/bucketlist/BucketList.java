package filescanner.bucketlist;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class BucketList {
    public static void main(String[] args) {
        // fájl beolvasása fájl rsz-ből:

        try(Scanner scanner = new Scanner(Path.of("bucketlist.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("Path.of: " + line);                     // Path.of: bucketlist.txt
                                                                            // Path.of: -> training-solutions/src
            }
        } catch (IOException ioe) {
            System.out.println("Cannot read bucketlist.txt file.");
        }


        // fájl beolvasása, ha az alkalmazás része:

        try(Scanner scanner = new Scanner(BucketList.class.getResourceAsStream("/bucketlist.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("getResourceAsStream: " + line);
                                                        // getResourceAsStream: bucketlist.txt
                                                        // getResourceAsStream: -> training-solutions/src/main/resources
            }
        }

        try(Scanner scanner = new Scanner(BucketList.class.getResourceAsStream("bucketlist.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("getResourceAsStream: " + line);
                                // getResourceAsStream: bucketlist.txt
                                // getResourceAsStream: -> training-solutions/src/main/resources/filescanner/bucketlist
            }
        }

        try(Scanner scanner = new Scanner(BucketList.class.getResourceAsStream
                ("/filescanner/bucketlist/bucketlist.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("getResourceAsStream: " + line);
                                // getResourceAsStream: bucketlist.txt
                                // getResourceAsStream: -> training-solutions/src/main/resources/filescanner/bucketlist
            }
        }

        try(Scanner scanner = new Scanner(BucketList.class.getResourceAsStream
                ("/training-solutions/src/main/java/filescanner/bucketlist/bucketlist.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("getResourceAsStream: " + line);
                                // NullPointerException
                                // ??? csak resource könyvtárból lehet, java könyvtárból nem?
            }
        }

    }


}
