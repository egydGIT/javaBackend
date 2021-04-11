package methodstructure.pendrives;

import java.util.ArrayList;
import java.util.List;

public class Pendrives {

    public Pendrive bestMy(List<Pendrive> pendrives) {
        Pendrive best = null;
        for (Pendrive pendrive: pendrives) {
            if (best == null || (pendrive.getPrice() / pendrive.getCapacity()) < best.getPrice() / best.getCapacity()) {
                best = pendrive;
            }
        }
        return best;
    }

    public Pendrive best(List<Pendrive> pendrives) {
        Pendrive min = pendrives.get(0);
        for (int j = 0; j < pendrives.size(); j++) {
            if (min.comparePricePerCapacity(pendrives.get(j)) == 1) {
                min = pendrives.get(j);
            }
        }
        return min;
    }

    public String cheapestMy(List<Pendrive> pendrives) {
        Pendrive cheapest = null;
        for (Pendrive pendrive: pendrives) {
            if (cheapest == null || pendrive.getPrice() < cheapest.getPrice()) {
                cheapest = pendrive;
            }
        }
        return cheapest.toString();
    }

    public Pendrive cheapest(List<Pendrive> pendrives) {
        Pendrive min = pendrives.get(0);
        for (int j = 0; j < pendrives.size(); j++) {
            if (pendrives.get(j).cheaperThan(min)) {
                min = pendrives.get(j);
            }
        }
        return min;
    }

    // Under construction, mert nem csak az utólsót kell megtatlálnia... sztem kell még egy lista, amibe elmenti

    public Pendrive risePriceWhenCapacityMy(List<Pendrive> pendrives, int percent, int capacity) {
        Pendrive findSearchedCapacity = null;
        for (Pendrive pendrive: pendrives) {
            if (findSearchedCapacity == null || pendrive.getCapacity() == capacity) {
                findSearchedCapacity = pendrive;
                findSearchedCapacity.risePrice(percent);
            }
        }
        return findSearchedCapacity;
    }

    public void risePriceWhenCapacity(List<Pendrive> pendrives, int percent, int capacity) {
        for (Pendrive p : pendrives) {
            if (p.getCapacity() == capacity) {
                p.risePrice(percent);
            }
        }
    }

    // Kiválogatja az összes capacity-ben meghatározott pendrivot
    public List<Pendrive> findWhenCapacityMy(List<Pendrive> pendrives, int percent, int capacity) {
        List<Pendrive> foundPendrives = new ArrayList<>();
        for (Pendrive pendrive: pendrives) {
            if (pendrive.getCapacity() == capacity) {
                foundPendrives.add(pendrive);
            }
        }
        return foundPendrives;
    }

    /*
    public Pendrive risePriceWhenCapacity2My(List<Pendrive> foundPendrives, int percent) {
        for (int i = 0; i < foundPendrives.size(); i++) {
            foundPendrives.get(i).risePrice(percent);
            foundPendrives.get(i).toString();
        }
    }

     */

}
