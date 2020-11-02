package classstructureconstructors;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.Scanner;

public class BookMain {
    public static void main(String[] args) {
        System.out.println("Author: ");
        Scanner scanner = new Scanner(System.in);
        String autor = scanner.nextLine();

        System.out.println("Tittle: ");
        String tittle = scanner.nextLine();

        System.out.println("RegNumber: ");
        int regNumber = scanner.nextInt();

        Book book = new Book(autor, tittle);
        book.register(18543);

        System.out.println("Author: " + book.getAuthor());
        System.out.println("Tittle: " + book.getTittle());
        System.out.println("RegNumber: " + book.getRegNumber());
    }
}

