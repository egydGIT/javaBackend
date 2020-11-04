package statements;

import java.util.Scanner;

public class TimeMain {
    public static void main(String[] args) {
        Time time = new Time();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Add meg az órát");
        int hour1 = scanner.nextInt();
        System.out.println("Add meg a percet");
        int minute1 = scanner.nextInt();
        System.out.println("Add meg a másodpercet");
        int second1 = scanner.nextInt();

        System.out.println(hour1 + " : " + minute1 + " : " + second1);
        time.getInSeconds1(hour1, minute1, second1);
        System.out.println(time.getInSeconds1(hour1, minute1, second1));

        System.out.println("Adj meg egy másik órát");
        int hour2 = scanner.nextInt();
        System.out.println("Adj meg egy másik percet");
        int minute2 = scanner.nextInt();
        System.out.println("Adj meg egy másik másodpercet");
        int second2 = scanner.nextInt();

        System.out.println(hour2 + " : " + minute2 + " : " + second2);
        time.getInSeconds2(hour2, minute2, second2);

        time.earlierThan();

    }
}
