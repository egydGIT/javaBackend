package controlselection.month;

import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

public class DayInMonth {
    LocalDate now = LocalDate.now();

    public Month getMonth(LocalDate now) {
        Month month = now.getMonth();
        return month;
    }

    public int dayInMonth(int answerYear, String answerMonth) throws IllegalAccessException {
        switch (answerMonth) {
            case "JANUÁR":
            case "ÁPRILIS":
            case "JÚNIUS":
            case "SZEPTEMBER":
            case "NOVEMBER":
                return 30;
            case "MÁRCIUS":
            case "MÁJUS":
            case "JÚLIUS":
            case "AUGUSZTUS":
            case "OKTÓBER":
            case "DECEMBER":
                return 31;
            case "FEBRUÁR":
                if (((answerYear % 4 == 0) &&                       // Szökőév
                        !(answerYear % 100 == 0))
                        || (answerYear % 400 == 0)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                throw new IllegalAccessException("Invalid month: " + answerMonth);
        }
    }


    public static void main(String[] args) throws IllegalAccessException {
        DayInMonth dayInMonth = new DayInMonth();
        System.out.println(dayInMonth.now);
        System.out.println(dayInMonth.getMonth(dayInMonth.now));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Kérlek add meg a hónapot! ");
        String answerMonth = scanner.nextLine().toUpperCase();

        System.out.println("Kérlek add meg az évet! ");
        int answerYear = scanner.nextInt();

        System.out.println(dayInMonth.dayInMonth(answerYear, answerMonth));

    }
}
