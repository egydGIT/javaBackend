package week03d04;

import java.util.Scanner;

public class PhoneParser {

    /*
    2020-11-12 (week03d04)
        Írj egy Phone oszályt, melynek van egy prefix és egy number String attribútuma!
        Írj egy PhoneParser osztályt egy parse(String) metódussal, ami beolvas egy 10-1234567 formátumú szöveget,
        és visszaad egy Phone objektumot, feltöltve a prefix értékét 10, a number értékét 1234567 értékekkel!
     */

    Phone phone;

    public String parse() {
        System.out.println("Kérem adja meg mobil számát! ");
        System.out.println("Formátum: 10-1234567");
        Scanner scanner = new Scanner(System.in);
        String printedNumber = scanner.nextLine();

        String prefix = printedNumber.substring(0, 2);
        String number = printedNumber.substring(3);

        Phone phone = new Phone(prefix, number);
        // System.out.println(phone.getPrefix());
        // System.out.println(phone.getNumber());
        System.out.println(phone.toString());
        return  phone.toString();
    }

    public static void main(String[] args) {
        PhoneParser phoneParser = new PhoneParser();
        phoneParser.parse();
    }
}
