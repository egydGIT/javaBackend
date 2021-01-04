package week04d03;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberMy {
    /*
    2020-11-18 (week04d03)
        Írj egy számkitaláló programot a GuessTheNumber osztályba!
        A program kitalál egy véletlenszerű számot 1 és 100 között.
        Majd bekér a felhasználótól ciklusban számokat.
        Mindig megmondja, hogy a szám, kisebb, nagyobb vagy egyenlő-e mint a gondolt szám.

        Bónusz feladat: max 6-szor lehet kérdezni!
     */

    public int guessTheNumber() {
        Random random = new Random();
        int number = random.nextInt(100) +1;
        // System.out.println(number);
        System.out.println("Gondoltam egy számra 1 és 100 között. Találd ki!");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int guessedNumber = scanner.nextInt();
            if (guessedNumber > number) {
                System.out.println("Ennél kisebbre gondoltam!");
            }
            if (guessedNumber < number) {
                System.out.println("Ennél nagyobbra gondoltam!");
            }
            if (guessedNumber == number) {
                System.out.println("Eltaláltad! A " + number + " számra gondoltam!");
                break;
            }
        }
        return number;
    }

    public static void main(String[] args) {
        GuessTheNumberMy guess = new GuessTheNumberMy();
        guess.guessTheNumber();
    }
}
