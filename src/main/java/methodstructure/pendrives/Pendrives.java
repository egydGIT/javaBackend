package methodstructure.pendrives;

import java.util.List;

public class Pendrives {

    public Pendrive best (List<Pendrive> pendrives) {
        Pendrive best = null;
        for (Pendrive pendrive: pendrives) {
            if (best == null || (pendrive.getPrice() / pendrive.getCapacity()) < best.getPrice() / best.getCapacity()) {
                best = pendrive;
            }
        }
        return best;
    }

    public String cheapest(List<Pendrive> pendrives) {
        Pendrive cheapest = null;
        for (Pendrive pendrive: pendrives) {
            if (cheapest == null || pendrive.getPrice() < cheapest.getPrice()) {
                cheapest = pendrive;
            }
        }
        return cheapest.toString();
    }


    // Under construction, mert nem csak az utólsót kell megtatlálnia... sztem kell még egy lista, amibe elmenti

    public Pendrive risePriceWhenCapacity(List<Pendrive> pendrives, int percent, int capacity) {
        Pendrive findSearchedCapacity = null;
        for (Pendrive pendrive: pendrives) {
            if (findSearchedCapacity == null || pendrive.getCapacity() == capacity) {
                findSearchedCapacity = pendrive;
                findSearchedCapacity.risePrice(percent);
            }
        }
        return findSearchedCapacity;
    }


}
