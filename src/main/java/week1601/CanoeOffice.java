/*
Kenukölcsönző
Írj egy olyan CanoeRental osztályt, amely String name, CanoeType canoeType, LocalDateTime startTime,
LocalDateTime endTime attribútumokban tárolja egy kenu kölcsönzés kölcsönzési adatait.
A CanoeType egy enum, mely értékei: RED, GREEN és BLUE.

Publikus metódusok:

public CanoeRental(String name, CanoeType canoeType, LocalDateTime startTime)
public void setEndTime(LocalDateTime endTime)
public double calculateRentalSum()
Minden kölcsönzés aktív, amíg vissza nem hozták a kenut, azaz ki nem töltötték az endTime értékét.

Írj egy CanoeOffice osztályt, mely tárolja, hogy milyen kölcsönzések történtek (List<CanoeRental>).

A következő metódusokat implementáld:

addRental(CanoeRental) - hozzáad egy kölcsönzést

findRentalByName(String name) - megkeres egy AKTÍV kölcsönzést név alapján

closeRentalByName(String name, LocalDateTime endTime) - megkeres egy AKTÍV kölcsönzést név alapján, beállítja az endTime értékét

double getRentalPriceByName(String name, LocalDateTime endTime) - kikeresi az AKTÍV kölcsönzést név alapján, és kiszámolja,
hogy a megadott kölcsönzés mennyibe kerülne. A számolás úgy történik, hogy óránként 5000 Ft-ot a szín alapján megszoroz egy értékkel,
piros, zöld és kék esetén rendre 1, 1,2 és 1,5 értékkel. Minden megkezdett óra számít.

List<CanoeRental> listClosedRentals() - Add vissza a lezárt kölcsönzéseket a startTime alapján sorbarendezve!

Map<CanoeType, Integer> countRentals() - Számold meg, hány kölcsönzés volt színenként!

Két dátum között eltelt órák számát a következőképp lehet kiszámítani:
Duration.between(beginDate, endDate).toHours()
 */

package week1601;

import java.time.LocalDateTime;
import java.util.*;

public class CanoeOffice {

    private final double BASIC_PRICE_PER_HOUR = 5000.0;
    private CanoeRental canoeRental;

    private List<CanoeRental> rentals = new ArrayList<>();

    public void addRental(CanoeRental rental) {
        // hozzáad egy kölcsönzést
        rentals.add(rental);
    }

    public CanoeRental findRentalByName(String name) {
        // megkeres egy AKTÍV kölcsönzést név alapján
        for (CanoeRental rental: rentals) {
            if (rental.getName().equals(name)) {
                return rental;
            }
        }
        throw new IllegalArgumentException("This name is not found: " + name);
    }

    public void closeRentalByName(String name, LocalDateTime endTime) {
        // megkeres egy AKTÍV kölcsönzést név alapján, beállítja az endTime értékét
        CanoeRental foundName = findRentalByName(name);
        foundName.setEndTime(endTime);
    }

    public double getRentalPriceByName(String name, LocalDateTime endTime) {
        // kikeresi az AKTÍV kölcsönzést név alapján, és kiszámolja, hogy a megadott kölcsönzés mennyibe kerülne.
        Double price = 0.0;
        CanoeRental foundName = findRentalByName(name);
        if ( foundName.getEndTime() == null ) {
            throw new IllegalArgumentException("This rental is still active. " + name);
        }
        double rentedHours = foundName.calculateRentalSum();
        return price = BASIC_PRICE_PER_HOUR * rentedHours * foundName.getCanoeType().getMultiplier();
    }

    public List<CanoeRental> listClosedRentals() {
        // Add vissza a lezárt kölcsönzéseket a startTime alapján sorbarendezve!
        List<CanoeRental> closedRentals = new ArrayList<>();
        for (CanoeRental rental: rentals) {
            if (rental.getEndTime() != null) {
                closedRentals.add(rental);
            }
        }
        Collections.sort(closedRentals, new Comparator<CanoeRental>() {
            @Override
            public int compare(CanoeRental o1, CanoeRental o2) {
                return o1.getStartTime().compareTo(o2.getStartTime());
            }
        });
        return closedRentals;
    }

    public Map<CanoeType, Integer> countRentals() {
        // Számold meg, hány kölcsönzés volt színenként!
        Map<CanoeType, Integer> countedTypes = new HashMap<>();
        for (CanoeRental rental: rentals) {
            if (!countedTypes.containsKey(rental.getCanoeType())) {
                countedTypes.put(rental.getCanoeType(), 1);
            }
            else {
                countedTypes.put(rental.getCanoeType(), countedTypes.get(rental.getCanoeType()) + 1);
            }
        }
        return countedTypes;
    }

    public double getBASIC_PRICE_PER_HOUR() {
        return BASIC_PRICE_PER_HOUR;
    }

    public List<CanoeRental> getRentals() {
        return rentals;
    }
}
