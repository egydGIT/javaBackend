package introcontrol;

import java.util.Arrays;
import java.util.List;

public class IntroControlMain {
    public static void main(String[] args) {
        IntroControl introControl = new IntroControl();
        // List<Integer> number = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        System.out.println("substractTenIfGreaterThanTen");
        System.out.println(introControl.subtractTenIfGreaterThanTen(9));
        System.out.println(introControl.subtractTenIfGreaterThanTen(19));
        System.out.println("");

        System.out.println("describeNumber");
        System.out.println(introControl.describeNumber(0));
        System.out.println(introControl.describeNumber(3));
        System.out.println("");

        System.out.println("greetingToJoe");
        System.out.println(introControl.greetingToJoe("Joe"));
        System.out.println(introControl.greetingToJoe("Jack"));
        System.out.println("");

        System.out.println("calculateBonus");
        System.out.println(introControl.calculateBonus(800_000));
        System.out.println(introControl.calculateBonus(1_200_000));
        System.out.println("");

        System.out.println("calculateConsumption");
        System.out.println(introControl.calculateConsumption(9500, 9650));
        System.out.println(introControl.calculateConsumption(9800, 50));
        System.out.println("");

        System.out.println("printNumbers");
        introControl.printNumbers(26);
        System.out.println("");
        System.out.println("");

        System.out.println("printNumbersBeetwen");
        introControl.printNumbersBetween(100, 110);
        System.out.println("");
        System.out.println("");

        System.out.println("printNumbersBeetwenAnyDirection");
        introControl.printNumbersBetweenAnyDirection(1,12);
        System.out.println("");
        introControl.printNumbersBetweenAnyDirection(12,1);
        System.out.println("");
        System.out.println("");

        System.out.println("printOddNumber");
        introControl.printOddNumber(31);
        System.out.println("");
        introControl.printOddNumber(30);
        System.out.println("");
    }
}
