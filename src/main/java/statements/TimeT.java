package statements;

public class TimeT {
    private int hour;
    private int minute;
    private int second;

    public TimeT(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getInMinutes() {
        return 60 * hour + minute;
    }

    public int getInSeconds() {
        return getInMinutes() * 60 + second;
    }

    public boolean earlierThan(TimeT other) {
        int thisTimeInSeconds = this.getInSeconds();
        int otherTimeInSeconds = other.getInSeconds();
        return thisTimeInSeconds < otherTimeInSeconds;
    }

    public String toString() {
        return hour + ":" + minute + ":" + second;
    }


}
