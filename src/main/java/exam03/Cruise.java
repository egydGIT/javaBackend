/*
Travel agency
Utazási iroda hajóutakat szervez. Minden hajóút egy adott hajóval történik, amelynek neve és befogadóképessége a
egy Boat osztályban van tárolva.

Az utasok adott hajóra, adott osztályra foglalnak helyet. A helyfoglaláskor azonban ellenőrizni kell,
hogy a befogadóképesség alapján van-e még hely. Ha nincs, egy kivételt várunk a megfelelő szöveggel.
A CruiseClass enum tárolja a különböző osztályokat. LUXURY, FIRST és SECOND osztályok vannak.
Az ár számolása úgy történik, hogy venni kell a hajóhoz tartozó alapárat,
és meg kell szorozni az osztályhoz tartozó szorzóval, rendre 3,0, 1,8 és 1,0.

bookPassenger(): egy foglalás. Ellenőrizni kell, hogy van-e még elég hely.
getPriceForPassenger(): visszaadja, hogy mennyibe kerülne a foglalás. Ez a metódus még NEM foglal.
findPassengerByName(): foglalás megkeresése név alapján
getPassengerNamesOrdered(): visszaadja a foglalást végzők neveit ábécé sorrendben
sumAllBookingsCharged(): összegzi, hogy mennyi az összes bevétel
countPassengerByClass(): visszaadja, hogy osztályonként mennyien foglaltak
 */

package exam03;

import java.time.LocalDate;
import java.util.*;

public class Cruise {

    private Boat boat;
    private LocalDate sailing;
    private double basicPrice;
    private Passenger passenger;

    private List<Passenger> passengers = new ArrayList<>();

    public Cruise(Boat boat, LocalDate sailing, double basicPrice) {
        this.boat = boat;
        this.sailing = sailing;
        this.basicPrice = basicPrice;
    }

    public List<Passenger> bookPassenger(Passenger passenger) {
        // egy foglalás. Ellenőrizni kell, hogy van-e még elég hely.
        if (passengers.size() >= boat.getMaxPassengers()) {
            throw new IllegalArgumentException("There's no free place on boat. You can't book.");
        }
        passengers.add(passenger);
        return passengers;
    }

    public double getPriceForPassenger(Passenger passenger) {
        // visszaadja, hogy mennyibe kerülne a foglalás. Ez a metódus még NEM foglal.
        double price = 0.0;
        price += passenger.getCruiseClass().getPrice();
//        for (Passenger p: passengers) {
//            price += p.getCruiseClass().getPrice();
//        }
        return boat.getBasicPrice() * price;
    }

    public Passenger findPassengerByName(String name) {
        // foglalás megkeresése név alapján
        Passenger passenger = null;
        for (Passenger p: passengers) {
            if (p.getName().equals(name)) {
                passenger = p;
            }
        }
        return passenger;
    }

//    public List<String> getPassengerNamesOrdered() {                           // Comparable if.
//        // visszaadja a foglalást végzők neveit ábécé sorrendben
//        List<String> passengerNames = new ArrayList<>();
//        for(Passenger p: passengers) {
//            passengerNames.add(p.getName());
//        }
//        Collections.sort(passengerNames);
//        return passengerNames;
//    }

//    public List<String> getPassengerNamesOrdered() {                             // Comparator + anonymus inner class
//        // visszaadja a foglalást végzők neveit ábécé sorrendben
//        List<String> passengerNames = new ArrayList<>();
//        for(Passenger p: passengers) {
//            passengerNames.add(p.getName());
//        }
//        Collections.sort(passengerNames, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });
//        return passengerNames;
//    }

    public List<String> getPassengerNamesOrdered() {                           // Comparator + inner class
        // visszaadja a foglalást végzők neveit ábécé sorrendben
        List<String> passengerNames = new ArrayList<>();
        for(Passenger p: passengers) {
            passengerNames.add(p.getName());
        }
        Collections.sort(passengerNames, new PassengerNameComparator());
        return passengerNames;
    }

    public class PassengerNameComparator implements Comparator<String> {        // inner class
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }

    public double sumAllBookingsCharged() {
        // összegzi, hogy mennyi az összes bevétel
        double sum = 0;
        for (Passenger p: passengers) {
            sum += (double) p.getCruiseClass().getPrice();
        }
        return boat.getBasicPrice() * sum;
    }

    public Map<CruiseClass, Integer> countPassengerByClass() {
        // visszaadja, hogy osztályonként mennyien foglaltak
        Map<CruiseClass, Integer> result = new HashMap<>();
        Integer counterLuxury = 0;
        Integer counterFirst = 0;
        Integer counterSecond = 0;
        for (Passenger p: passengers) {
            if ( p.getCruiseClass() == CruiseClass.LUXURY ) {
                counterLuxury++;
            }
            if( counterLuxury != 0) {
                result.put(CruiseClass.LUXURY, counterLuxury);
            }
        }
        for (Passenger p: passengers) {
            if ( p.getCruiseClass() == CruiseClass.FIRST ) {
                counterFirst++;
            }
            if( counterFirst != 0) {
                result.put(CruiseClass.FIRST, counterFirst);
            }
        }
        for (Passenger p: passengers) {
            if ( p.getCruiseClass() == CruiseClass.SECOND ) {
                counterSecond++;
            }
            if( counterSecond != 0) {
                result.put(CruiseClass.SECOND, counterSecond);
            }
        }
        return result;
    }

    public Boat getBoat() {
        return boat;
    }

    public LocalDate getSailing() {
        return sailing;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }
}
