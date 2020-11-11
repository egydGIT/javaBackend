package stringtype.registration;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Felhasználónév: ");
        String username = scanner.nextLine();

        System.out.println("Jelszó: ");
        String password1 = scanner.nextLine();

        System.out.println("Jelszó még egyszer: ");
        String password2 = scanner.nextLine();

        UserValidator user1 = new UserValidator(username, password1, password2);

        System.out.println( user1.isValidUsername(username) ? "A felhasználónév megadása sikeres." : "A felhasználónév megadása kötelező.");
        System.out.println( user1.isValidPassword(password1, password2) ? "A jelszó megadása sikeres" : "A jelszó megadása sikertelen.");

    }
}
