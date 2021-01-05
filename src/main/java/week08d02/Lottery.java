package week08d02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lottery {

    /*
    Junior
    Készíts a week08d02 csomagban egy Lottery osztályt, melynek legyen egy getNumbers() metódusa, ami visszaad egy
    listát amiben 5 véletlen szám van 1-90 között, tehát kvázi készíts egy lottósorsoló programot.
    A sorrendre nem kell figyelni, a lényeg, hogy a számok különbözők legyenek!
     */


    public List<Integer> getNumber() {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random(77);                     // seed teszt miatt megadva
        for (int i = 1; i <= 5; i++) {
            int number = random.nextInt(90) +1;
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        return numbers;
    }

    public static void main(String[] args) {
        Lottery lottery = new Lottery();
        System.out.println(lottery.getNumber());
    }
}
