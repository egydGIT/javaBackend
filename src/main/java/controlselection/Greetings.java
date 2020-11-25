package controlselection;

import java.time.LocalTime;

public class Greetings {

    LocalTime now = LocalTime.now();

    public int getHour(LocalTime now) {
        int hour = now.getHour();
        return hour;
    }

    public int getMinute(LocalTime now) {
        int minute = now.getMinute();
        return minute;
    }

    public int letsGreet(int hour, int minute) {
        int allMinuteUntilNow = hour * 60 + minute;
        int fiveClock = 300;
        int nineClock = 540;
        int halfPastSixPm = 1110;
        int eightPm = 1200;


        if (allMinuteUntilNow >= fiveClock && allMinuteUntilNow < nineClock ) {
            System.out.println("Jó reggelt!");
        }
        if (allMinuteUntilNow >= nineClock && allMinuteUntilNow < halfPastSixPm ) {
            System.out.println("Jó napot!");
        }
        if (allMinuteUntilNow >= halfPastSixPm && allMinuteUntilNow < eightPm ) {
            System.out.println("Jó estét!");
        }
        if (allMinuteUntilNow >= eightPm || allMinuteUntilNow < fiveClock ) {
            System.out.println("Jó éjt! Menj aludni! :-)  ");
        }
        return allMinuteUntilNow;
    }



    public static void main(String[] args) {
        Greetings greetings = new Greetings();

        System.out.println("Pontos idő: " + greetings.now);

        // System.out.println(greetings.letsGreet(18, 51));

        System.out.println("Óra: " + greetings.getHour(greetings.now));
        System.out.println("Perc: " + greetings.getMinute(greetings.now));
        System.out.println(greetings.letsGreet(greetings.getHour(greetings.now), greetings.getMinute(greetings.now)));
    }
}
