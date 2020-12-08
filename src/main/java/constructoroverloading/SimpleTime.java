package constructoroverloading;

import methodoverloading.Time;

public class SimpleTime {
    private int hours;
    private  int minutes;

    public SimpleTime(int hours) {
        this(hours, 0);
    }

    public SimpleTime(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public SimpleTime(SimpleTime time) {
        this(time.hours, time.minutes);
    }

    public int difference(SimpleTime time) {
        return timeInMinutes() - time.timeInMinutes();
    }

    public int timeInMinutes() {
        return 60 * hours + minutes;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    @Override
    public String toString() {
        return hours + ":" + minutes;
    }

    public static void main(String[] args) {
        SimpleTime time1 = new SimpleTime(19);
        SimpleTime time2 = new SimpleTime(19, 32);
        SimpleTime time3 = new SimpleTime(time2);

        System.out.println(time1);
        System.out.println(time2);
        System.out.println(time3);

        System.out.println(time1.timeInMinutes());
        System.out.println(time2.timeInMinutes());

        System.out.println(time1.difference(time2));


    }

}
