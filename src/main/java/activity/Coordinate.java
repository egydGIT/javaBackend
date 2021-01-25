/*
Coordinate immutable osztály:
Két adattagja van: a szélességi és hosszúsági fok (latitude,longitude), előbbi az értéke [-90,90] intervallumon,
utóbbi értéke a [-180,180] intervallumon mozoghat. Mindkét adattaghoz tartozik egy getter.
 */

package activity;

public class Coordinate {

    private final double latitude;                                 // [-90,90] intervallumon

    private final double longitude;                                 // [-180,180]

    public Coordinate(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

}
