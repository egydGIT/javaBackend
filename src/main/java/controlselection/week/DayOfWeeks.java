package controlselection.week;

import java.util.Scanner;

public class DayOfWeeks {
    public void typeOfDay(String answerDay) {
        switch (answerDay) {
            case "HÉTFŐ":
                System.out.println("hét eleje");
                return;
            case "KEDD":
            case "SZERDA":
            case "CSÜTÖRTÖK":
                System.out.println("hét közepe");
                return;
            case "PÉNTEK":
                System.out.println("majdnem hétvége");
                return;
            case "SZOMBAT":
            case "VASÁRNAP":
                System.out.println("hétvége");
                return;
            default:
                throw new IllegalArgumentException("Invalid day: " + answerDay);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kérlek add meg a napot! ");
        String answerDay = scanner.nextLine().toUpperCase();

        new DayOfWeeks().typeOfDay(answerDay);


    }
}
