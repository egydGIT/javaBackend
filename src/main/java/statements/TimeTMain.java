package statements;

import java.util.Scanner;

public class TimeTMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Add meg az órát");
        int hour1 = scanner.nextInt();
        System.out.println("Add meg a percet");
        int minute1 = scanner.nextInt();
        System.out.println("Add meg a másodpercet");
        int second1 = scanner.nextInt();

        System.out.println(hour1 + " : " + minute1 + " : " + second1);

        System.out.println("Adj meg egy másik órát");
        int hour2 = scanner.nextInt();
        System.out.println("Adj meg egy másik percet");
        int minute2 = scanner.nextInt();
        System.out.println("Adj meg egy másik másodpercet");
        int second2 = scanner.nextInt();

        System.out.println(hour2 + " : " + minute2 + " : " + second2);

        TimeT timeT1 = new TimeT(hour1, minute1, second1);
        TimeT timeT2 = new TimeT(hour2, minute2, second2);

        int allSeconds1 = timeT1.getInSeconds();
        System.out.println(allSeconds1);

        int allSeconds2 = timeT2.getInSeconds();
        System.out.println(allSeconds2);



        if (allSeconds1 < allSeconds2) {
            System.out.println("Az első dátum korábbi.");
        } else {
            System.out.println("Az első dátum későbbi.");
        }


        System.out.println(timeT1.earlierThan(timeT2));

    }
}
