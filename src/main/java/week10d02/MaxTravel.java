/*
Junior
Van egy egész számok listája, amelyben egy szám azt jelzi, hogy az adott számú buszmegállóban egy ember fel akar szállni.
A 12,12,0,3,4,4 sorozat tehát azt jelenti, hogy a 12-es buszmegállóban 2-en, a 0-ásban 1 ember, 3-asban egy ember,
4-esben 2 ember akar felszállni. A MaxTravel osztály getMaxIndex() metódusa adja vissza,
hogy hanyas megállóban szeretnének a legtöbben felszálln! Maximum 30 megálló lehet.
 */

package week10d02;

import java.util.Arrays;
import java.util.List;

public class MaxTravel {

    public static final int MAX_AMOUNT_OF_STOPS = 30;

    public int getMaxIndex(List<Integer> stops) {
        int[] possibleStops = new int[30];

        for (int i = 0; i < stops.size(); i++) {
            if ( stops.get(i) > MAX_AMOUNT_OF_STOPS || stops.isEmpty()) {
                throw new IllegalArgumentException("Stop list is invalid");
            }
            possibleStops[stops.get(i)]++;
        }
        int biggestStop = 0;
        int biggestStopNumber = 0;

        for (int j = 0; j < possibleStops.length; j++) {
            if (possibleStops[j] > biggestStop) {
                biggestStop = possibleStops[j];
                biggestStopNumber = j;
            }
        }
        return biggestStopNumber;
    }

    public static void main(String[] args) {
        MaxTravel maxTravel = new MaxTravel();
        System.out.println(maxTravel.getMaxIndex(Arrays.asList(12,12,12,0,3,4,4)));
        System.out.println(maxTravel.getMaxIndex(Arrays.asList(5, 7,7,7, 8, 9,9,9,9,9, 10, 11,11)));
    }
}
