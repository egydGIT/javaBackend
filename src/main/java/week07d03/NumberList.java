package week07d03;

import java.util.Arrays;
import java.util.List;

public class NumberList {

    /*
    Junior
    Hozz létre egy NumberList osztályt! Ennek legyen egy metódusa isIncreasing(List<Integer>),
    mely egy számokból álló listát vár paraméterül és megnézi, hogy a listában a számok növekvő sorrendben szerepelnek-e
    és ennek megfelelően igaz vagy hamis értékkel tér vissza! Speciális eset ha két egymást követő szám egyenlő,
    ez nem probléma a 1, 2, 3, 3, 3, 5 számokat növekvőnek tekintjük.
     */

    public boolean isIncreasingMy(List<Integer> numbers) {   // Ha az utólsó reláció növekvő, akkor az egészet annak veszi.
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i-i) < numbers.get(i)) {
                return true;
            }
        }
        return false;
    }

    public boolean isIncreasing(List<Integer> numbers) {
        int before = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) < before) {
                return false;
            }
            before = numbers.get(i);
        }
        return true;
    }

    public static void main(String[] args) {
        NumberList numberList = new NumberList();
        System.out.println(numberList.isIncreasing(Arrays.asList(1, 2, 3, 7, 8, 12, 18, 20)));
        System.out.println(numberList.isIncreasing(Arrays.asList(8, 5, 3, 1)));
        System.out.println(numberList.isIncreasing(Arrays.asList(5, 2, 9, 7, 12)));
    }

}
