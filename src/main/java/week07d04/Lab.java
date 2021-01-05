package week07d04;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Lab {
    /*
    Junior
    Hozz létre egy Lab nevű osztályt, ami azt tárolja el, hogy melyik feladattal készültél el!
    + Három attribútuma: title ami a tananyag neve, egy completed, hogy elkészültél-e vele, és a completedAt,
    ami azt tárolja, hogy mikor!
    + Legyen két konstruktora! Az egyik csak a címet várja, ekkor úgy állítsa be a példányt, hogy még nem készültél el.
    + Legyen egy másik, ami várja a címet és a dátumot. Ekkor azt állítsa be, hogy elvégezted a gyakorlati feladatot.
    + Írj egy complete metódust, ami kap egy dátumot, és beállítja, hogy elvégezted a gyakorlati feladatot.
    + Legyen egy complete metódusa, ami semmit nem vár, ez azt állítja be, hogy MOST végezted el a gyakorlati feladatot.
    + Írd meg a toString metódusát is!
     */

    // private String title;
    private Title title;
    private boolean completed;
    private LocalDate completedAt;

    public Lab(Title title) {                                           // Konstruktor túlterhelés
        this.title = title;
        this.completed = false;
    }

    public Lab(Title title, LocalDate completedAt) {
        this.title = title;
        this.completedAt = completedAt;
        this.completed = true;
    }

    public LocalDate complete(int year, int month, int day) {           // Metódus túlterhelés
        this.completed = true;                                              // a met.-ban is készre állítom a feladatot
        return this.completedAt = LocalDate.of(year, month, day);
    }

    public LocalDate complete() {
        this.completed = true;
        return this.completedAt = LocalDate.now();
    }

    public Title getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public LocalDate getCompletedAt() {
        return completedAt;
    }

    @Override
    public String toString() {
        return "Lab{" +
                "title='" + title + '\'' +
                ", completed=" + completed +
                ", completedAt=" + completedAt +
                '}';
    }

    public static void main(String[] args) {
        Lab lab1 = new Lab(Title.LISTEN_CONSULTATION_VIDEOS);
        Lab lab2 = new Lab(Title.TAKE_NOTES);
        Lab lab3 = new Lab(Title.LISTEN_VOCATIONAL_VIDEOS);
        Lab lab4 = new Lab(Title.DO_EXCERCISES);

        System.out.println(lab1);

        lab1.complete(2020, 12, 22);
        lab2.complete(2020, 12, 23);
        lab3.complete(2021, 01, 03);
        lab4.complete();

        System.out.println(lab1);

    }
}
