package methodoverloading;

public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {                // konstruktor overloading (4db)
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public Time(int hours) {
        this.hours = hours;
    }

    public Time(Time time) {                                            // copy konstruktor
        this.hours = time.hours;                                                // attr-ai értékét a par-ként átadott obj.
        this.minutes = time.minutes;                                            // azonos attr-nak értékére állítja be
        this.seconds = time.seconds;
    }

                                                                        // metódus overloading
                                                                        // Két külön metódus:
    public boolean isEqual (Time time) {                                        // - azonos metódus név
        return  timeInSeconds() == time.timeInSeconds();                        // - de más par. signatura (típusa u.a, neve eltérhet)
    }                                                                           // - visszatérési érték is különbözhet


    public boolean isEqual (int hours, int minutes, int seconds) {
        Time time = new Time(hours, minutes, seconds);
        return isEqual(time);
    }

    public boolean isEqual2 (int hours, int minutes, int seconds) {                         // Azonos metódusok, ha: ( -> hibaüzenet)
        if (this.hours == hours && this.minutes == minutes && this.seconds == seconds) {        // - ha neve ugyanaz
            return true;                                                                        // - paraméterek típusa is megegyezik
        }                                                                                       // - par.-ek neve nem befolyásol
        return false;
    }

    public boolean isEarlier (Time time) {
        return timeInSeconds() < time.timeInSeconds();
    }

    public boolean isEarlier (int hours, int minutes, int seconds) {
        Time time = new Time(hours, minutes, seconds);
        return isEarlier(time);
    }

    public int timeInSeconds() {
        return (60 * 60 * hours) + (60 * minutes) + seconds;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    @Override
    public String toString() {
        return hours + " : " + minutes + " : " + seconds;
    }

    public static void main(String[] args) {
        Time time = new Time(16, 8, 40);
        System.out.println(time.toString());
        System.out.println(time.timeInSeconds());

        // isEqual met-ok
        Time time2 = new Time(16, 8, 40);
        System.out.println(time.isEqual(time2));
        System.out.println(time.isEqual(16,8,40));
        System.out.println(time.isEqual2(16,8,40));

        // isEarlier met-ok:
        System.out.println(time.isEarlier(new Time(16,2,00)));
        System.out.println(time.isEarlier(16,2,00));

    }
}
