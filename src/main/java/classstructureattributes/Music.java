package classstructureattributes;

import java.util.Scanner;

public class Music {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Song song = new Song();

        System.out.println("What is YOUR favourite song?");

        System.out.println("Band name: ?");
        song.band = scanner.nextLine();

        System.out.println("Tittle of the song: ?");
        song.title = scanner.nextLine();

        System.out.println("Length: ?");
        song.length = scanner.nextInt();

        System.out.println(song.band + "-" + song.title + "(" + song.length + ")");

        System.out.println("What is the Trainer's favourite song?");

        song.band = "Wolfgang Amadeus Mozart";
        song.title = "41., C-dúr szimfónia";
        song.length = 40;

        System.out.println(song.band + "-" + song.title + "(" + song.length + "perc)");

    }
}
