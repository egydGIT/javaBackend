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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        passengers.add(passenger);
        return passengers;
    }

//    public double getPriceForPassenger(Passenger passenger) {
//        // visszaadja, hogy mennyibe kerülne a foglalás. Ez a metódus még NEM foglal.
//
//    }

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

//    public List<String> getPassengerNamesOrdered() {
//        // visszaadja a foglalást végzők neveit ábécé sorrendben
//
//    }

    public double sumAllBookingsCharged() {
        // összegzi, hogy mennyi az összes bevétel
        double sum = 0;
        for (Passenger p: passengers) {
            sum += (double) p.getCruiseClass().getPrice();
        }
        return 100_000 * sum;
    }

    public Map<CruiseClass, Integer> countPassengerByClass() {
        // visszaadja, hogy osztályonként mennyien foglaltak
        Map<CruiseClass, Integer> result = new HashMap<>();
        CruiseClass luxury = null;
        Integer counterLuxury = 0;
        Integer counterFirst = 0;
        Integer counterSecond = 0;
        for (Passenger p: passengers) {
            if ( p.getCruiseClass() == CruiseClass.LUXURY ) {
                counterLuxury++;
            }
            result.put(CruiseClass.LUXURY, counterLuxury);
        }
        for (Passenger p: passengers) {
            if ( p.getCruiseClass() == CruiseClass.FIRST ) {
                counterFirst++;
            }
            result.put(CruiseClass.FIRST, counterFirst);
        }
//        for (Passenger p: passengers) {
//            if ( p.getCruiseClass() == CruiseClass.SECOND ) {
//                counterSecond++;
//            }
//            result.put(CruiseClass.SECOND, counterSecond);
//        }
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
