package introconstructors;

import java.time.LocalDateTime;

public class TaskMain {
    public static void main(String[] args) {
        Task task = new Task("Java backend", "Java programozási nyelv részletes megismerése. ");

        System.out.println("Feladat: " + task.getTitle());
        System.out.println("Leírás: " + task.getDescription());

        task.start();
        task.setDuration(360);

        System.out.println("Rászánt idő min.: " + task.getDuration() + " perc/nap");
    }

}

