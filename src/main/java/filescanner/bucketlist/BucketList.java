package filescanner.bucketlist;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class BucketList {
    public static void main(String[] args) {

        try(Scanner scanner = new Scanner(Path.of("bucketlist.txt"))) {     // fájl beolvasása fájl rsz-ből:
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("Path.of: " + line);                     // Path.of: bucketlist.txt
                                                                            // Path.of: -> tarining-solutions/src
            }
        } catch (IOException ioe) {
            System.out.println("Cannot read bucketlist.txt file.");
        }

        try(Scanner scanner = new Scanner(BucketList.class.getResourceAsStream("/bucketlist.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("getResourceAsStream: " + line);
                                                        // getResourceAsStream: bucketlist.txt
                                                        // getResourceAsStream: -> tarining-solutions/src/main/resources
            }
        }
/*
        try(Scanner scanner = new Scanner(BucketList.class.getResourceAsStream("bucketlist.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("getResourceAsStream: " + line);
                                                        //
                                                        //
            }
        }

 */

    }


}
