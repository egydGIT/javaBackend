package week07d01;

import java.util.ArrayList;
import java.util.List;

public class MathAlgorithms {

    /*
    Junior
    Készíts egy osztályt MathAlgorithms néven. Ebben az osztályban legyen egy isPrime(int x) metódus ami
    a paraméterül kapott számról eldönti, hogy prím-e vagy sem és ennek megfelelően true vagy false értékkel tér vissza.
    Aki már tart ott és tudja mit jelent a static az nyugodtan implementálhatja a metódust statikus metódusként.
    Az egyszerűség kedvért a prímeket most csak a pozitív egész számok körében értelmezzük,
    így bónuszként rá lehet ellenőrizni, hogy x > 0, és ha nem, akkor kivételt dobni.
    Prímeknek tekintjük azokat számokat melyek csak egyel és önmagukkal oszthatók, tehát a 2, 3, 5, 7, 11, 13 stb.
     */

    public boolean isPrime(int x) {
        if ( x < 1 ) {
            throw new IllegalArgumentException("A prímeket most csak a pozitív egész számok körében értelmezzük.");
        }
        if ( x == 1 ) {
            return false;
        }
        if ( x == 2 ) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if ( x % i == 0 ) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        MathAlgorithms mathAlgorithms = new MathAlgorithms();
        System.out.println("1: " + mathAlgorithms.isPrime(1));
        System.out.println("2: " + mathAlgorithms.isPrime(2));
        System.out.println("4: " + mathAlgorithms.isPrime(4));
        System.out.println("5: " + mathAlgorithms.isPrime(5));
        System.out.println("11: " + mathAlgorithms.isPrime(11));
        System.out.println("13: " + mathAlgorithms.isPrime(13));
        System.out.println("20: " + mathAlgorithms.isPrime(20));

    }
}
