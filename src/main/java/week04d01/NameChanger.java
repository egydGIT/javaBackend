package week04d01;

import java.util.Scanner;

public class NameChanger {

    /*
    2020-11-16 (week04d01)
        Készítsd el a NameChanger osztályt, melynek privát attribútuma legyen a String fillName,
        mely egy ember teljes nevét reprezentálja!
        A fullName attribútum [vezetéknév][szóköz][keresztnév] formátumban épül fel.
        A konstruktor állítsa be a paraméterül kapott értékre az adattagot, de ha az érték null, vagy üres String,
        akkor dobjon egy IllegalAgrumentException kivételt a következő üzenettel: Invalid name:[paraméter értéke]!

        Legyen egy changeFirstName(String firstName) metódusa,
        mely megváltoztatja az objektum állapotát és kicseréli a vezetéknevet a paraméterül kapott értékre!
     */

    private String fillName;            // ??
    private String fullName;
    private String firstName;
    private String givenName;

    public NameChanger(String firstName, String givenName) {
        if (isEmpty(firstName) || isEmpty(givenName)) {
            throw new IllegalArgumentException("Invalid name: " + firstName + " or " + givenName);
        }
        this.firstName = firstName;
        this.givenName = givenName;
    }

    public String getFullName() {
        return fullName = firstName.trim() + " " + givenName.trim();
    }

    public String changeFirstName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please give the new firstname! ");
        String newFirstName = scanner.nextLine().trim();
        return firstName = newFirstName;
    }

    private boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }

    public static void main(String[] args) {
        // fullName beállítása:
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please give your firstname!");
        String firstName = scanner.nextLine();
        System.out.println("Please give your givenname!");
        String givenName = scanner.nextLine();

        NameChanger nameChanger = new NameChanger(firstName, givenName);
        System.out.println(nameChanger.getFullName());

        // changeFirstName
        nameChanger.changeFirstName();
        System.out.println(nameChanger.getFullName());
    }
}
