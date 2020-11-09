package statements;

import java.util.Scanner;

public class DivByThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Addj meg egy számot! Megmondom, osztható-e hárommal!");
        int numberFromUser = scanner.nextInt();

        System.out.println(numberFromUser % 3 == 0 ? "Igen, a szám három többszöröse." : "Nem, a szám nem osztható maradék nélkül hárommal.");
    }
}
