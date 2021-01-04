package week05d03;

import java.util.Scanner;

public class ListCounter {
    /*
    Junior
    Írj egy olyan metódust a ListCounter osztályban, mely a kapott String listából összeszámolja azokat,
    amelyek a vagy A betűvel kezdődnek!
    Ha nulla elemű a tömb, vagy nincs benne ilyen elem, akkor nulla értéket adjon vissza!
     */

    public int countStartWithA(String text) {                       // nem listával dolgozok, csak Stringgel
        Scanner scanner = new Scanner(text).useDelimiter(" ");
        int count = 0;
        while (scanner.hasNext()) {
            String t = scanner.next();
            if ( t.startsWith("a")) {
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        ListCounter listCounter = new ListCounter();
        System.out.println(listCounter.countStartWithA("az alma érésének ideje az, amikor"));
        System.out.println(listCounter.countStartWithA("itt egy sem kezdődik"));
    }
}
