package classstructureconstructors;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.Scanner;

public class BookMain {
    public static void main(String[] args) {
        Book book = new Book("Exupery", "A kisherceg");
        book.register(18543);

        System.out.println("Author " + book.getAuthor());
        System.out.println("Tittle: " + book.getTittle());
        System.out.println("Reg.number: " + book.getTittle());
    }
}

