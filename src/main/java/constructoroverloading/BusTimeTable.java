package constructoroverloading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BusTimeTable {
    private List<SimpleTime> timeTable;
    // private int firstHour;
    // private int lastHour;
    // private int everyMinute;

    public BusTimeTable(List<SimpleTime> timeTable) {                       // Konstruktor 1, paraméter a lista
        this.timeTable = timeTable;
    }

    public BusTimeTable(int firstHour, int lastHour, int everyMinute) {     // Konstruktor 2, paraméter a tól-ig óra, perc
        List<SimpleTime> generatedTimeTable = new ArrayList<>();                // lista a generálét adatok tárolására
        for (int i = firstHour; i <= lastHour; i++) {                           // for ciklus tól-ig órák között iterál
            generatedTimeTable.add(new SimpleTime(i, everyMinute));             // listához adja hozzá:
        }                                                                            // SimpleTime oszt 2 param-es konstr-val létrehozott időpontot
        timeTable = generatedTimeTable;                                         // térjen vissza a listával
    }

    public List<SimpleTime> getTimeTable() {
        return timeTable;
    }

    public SimpleTime nextBus(SimpleTime actual) {                         // aktuális idő megadásával kiírja a köv. buszt
        for (int i = 0; i < timeTable.size(); i++) {                       // for ciklus, végigiterál a listán
            if (timeTable.get(i).difference(actual) >= 0) {                    // minden elemre meghívja a difference met-t
                                                                               // ez megadja a megadott idő - busz indulés
                return timeTable.get(i);                                            // ha ez nagyobb, egyenlő nullával
            }                                                                       // kiírja az első ilyen időpontot
        }
        throw new IllegalStateException("No more buses today!");               // kivételt dob, ha nincs ilyen elem a listában
    }

    public SimpleTime firstBus(List<SimpleTime> timeTable) {
        SimpleTime min = new SimpleTime(24,00);
        for (SimpleTime t: timeTable) {
            if (t.timeInMinutes() < min.timeInMinutes()) {
                min = t;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        BusTimeTable busTimeTable = new BusTimeTable(5, 21, 40);
        System.out.println(busTimeTable.getTimeTable());

        System.out.println("Következö busz indul: " + busTimeTable.nextBus(new SimpleTime(20, 8)));
        // System.out.println("Következö busz indul: " + busTimeTable.nextBus(new SimpleTime(22, 30)));

        List<SimpleTime> timetable = Arrays.asList(
                new SimpleTime(17, 15),
                new SimpleTime(20, 15),
                new SimpleTime(14, 15),
                new SimpleTime(5, 15),
                new SimpleTime(9, 15)
        );

        System.out.println(busTimeTable.firstBus(timetable));
    }
}
