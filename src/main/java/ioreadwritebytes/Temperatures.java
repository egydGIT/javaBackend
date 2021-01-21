package ioreadwritebytes;

public class Temperatures {
    private byte[] data;                                // 365 nap adatai

    public Temperatures(byte[] data) {
        this.data = data;
    }

    public double getYearAverage() {
        double sum = 0.0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        return sum / 365;
    }

    public double getMonthAverage() {
        double sum = 0.0;
        for (int i = data.length-1; i > data.length - 31; i--) {
            sum += data[i];
        }
        return sum / 30;
    }

    public byte[] getData() {
        return data;
    }
}
