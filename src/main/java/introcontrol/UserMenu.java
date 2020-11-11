package introcontrol;

import java.util.Scanner;

public class UserMenu {
    public static void main(String[] args) {
        System.out.println("1. Felhasználók listázása ");
        System.out.println("2. Felhasználó felvétele ");
        System.out.println("Egyéb: Kilépés ");

        System.out.println("Kérem válasszon a menüpontok alapján: ");
        Scanner scanner = new Scanner(System.in);
        String chooseMenu = scanner.nextLine();

        if ( chooseMenu.contains("1")) {
            System.out.println("1. Felhasználók listázása " );
        } else if ( chooseMenu.contains("2")) {
            System.out.println("2. Felhasználó felvétele " );
        }
    }
}
