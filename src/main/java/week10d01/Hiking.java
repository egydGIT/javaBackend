/*
Junior
Túrázás közben egy GPS eszköz rögzíti a pontokat.
Eltárolja a GPS koordinátákat, valamint a magasságot (mindegyik lebegőpontos érték).
Írj a week10d01.Hiking osztályba egy getPlusElevation() metódust, mely megkapja a magasságok listáját,
és visszaadja a emelkedések összegét. Azaz pl. 10,20,15,18 esetén 13, ugyanis (20 - 10) + (18 - 15).
A 20 méterről 15 méterre ereszkedést nem számolja bele, hiszen az ereszkedés, és nem emelkedés.
 */

package week10d01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hiking {

    public double getPlusElevation(List<Double> elevationList) {
        if (elevationList == null) {
            throw new IllegalArgumentException("No list.");
        }
        double result = 0;
        for (int i = 1; i < elevationList.size(); i++) {
            if (elevationList.get(i) > elevationList.get(i-1)) {
                result += elevationList.get(i) - elevationList.get(i-1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Hiking hiking = new Hiking();
        List<Double> elevationList = Arrays.asList(10.0, 20.0, 15.0, 18.0);

        System.out.println(hiking.getPlusElevation(elevationList));                     // 13
    }

}
