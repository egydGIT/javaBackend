package methodparam;

import java.util.Arrays;

public class Measurement {
    private int [] measurements;                                // paraméter, tömb

    public Measurement(int[] measurements) {                    // Konstruktor
        this.measurements = measurements;
    }

    public int findFirstIndexInLimitMy(int lower, int upper) {   // Első olyan mérési eredmény indexe, ami a megadott határok között
        for (int i = 0; i < measurements.length; i++) {                     // Eldöntés algoritmusa
            if (measurements[i] < upper && measurements[i] > lower) {
                return i;
            }
        }
        return -1;
    }

    public int minimumMy() {                              // Legkisebb mérési eredmény: szélsőérték algoritmus
        int min = Integer.MAX_VALUE;
        for (Integer m: measurements) {
            if (m < min) {
                min = m;
            }
        }
        return  min;
    }

    public double minimum() {
        double min = measurements[0];
        for (int j = 1; j < measurements.length; j++) {
            if (measurements[j] < min) {
                min = measurements[j];
            }
        }
        return min;
    }

    public int maximumMy() {                              // Legnagyobb mérési eredmény: szélsőérték algoritmus
        int max = Integer.MIN_VALUE;
        for (Integer m: measurements) {
            if (m > max) {
                max = m;
            }
        }
        return  max;
    }

    public double maximum() {
        double max = measurements[0];
        for (int j = 1; j < measurements.length; j++) {
            if (measurements[j] > max)
                max = measurements[j];
        }
        return max;
    }

    public ExtremeValues minMaxMy() {                     // Legnagyobb és legkisebb mérési eredményt adja vissza
        return new ExtremeValues(minimumMy(), maximumMy());         // ehhez új osztály (immutable tipusú), ezt példányosítja
    }                                                           // melynek értékeit a fenti szélsőérték metódusok szolgáltatják


    public static void main(String[] args) {
        int [] measurements = {25, 58, 69, 42, 71, 65, 66, 32, 3, 75, 97};
        System.out.println("Mérési eredmények: " + Arrays.toString(measurements));
        Measurement measurement = new Measurement(measurements);
        System.out.println("Min: " + measurement.minimumMy());
        System.out.println("Max: " + measurement.maximumMy());

        ExtremeValues extremeValues = new ExtremeValues(measurement.minimumMy(), measurement.maximumMy());
        System.out.println("ExtremeValues: " + extremeValues.toString());

    }
}
