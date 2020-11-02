package classstructuremethods;

import java.util.Scanner;

public class NoteMain {
    public static void main(String[] args) {
        Note note = new Note();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please give your name: ");
        String name = scanner.nextLine();
        note.setName(name);                // Ezt puskázni kellett.

        System.out.println("Select topic: ");
        String topic = scanner.nextLine();
        note.setTopic(topic);

        System.out.println("Sort message: ");
        String text = scanner.nextLine();
        note.setText(text);

        System.out.println(note.getNoteText());
    }
}
