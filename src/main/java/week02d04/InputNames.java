package week02d04;

import java.util.Arrays;
import java.util.Scanner;

public class InputNames {

    /*
    2020-11-05 (week02d04)
        Hozz létre egy InputNames Java osztályt, melynek van egy main metódusa.
        Ciklusban kérj be öt nevet! A neveket tárold el egy tömbben!
        Írd ki a tömb tartalmát, sortöréssel elválasztva (írd bele, hogy hanyadik elem - 1-től sorszámozva)!
     */

    private String name;
    private String [] names;

    public static void main(String[] args) {
        String[] names = new String[5];
        for (int i = 0; i < names.length; i++) {
            System.out.println("Kérem adja meg a/az " + (i+1) + ". nevet! ");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            names[i] = name;
        }
        // System.out.println(Arrays.asList(names));
        for (int i = 0; i < names.length; i++) {
            System.out.println((i+1) + ". " + names[i]);
        }
    }
}
