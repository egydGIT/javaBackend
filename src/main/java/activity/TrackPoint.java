/*
TrackPoint osztály: Van egy koordináta és egy emelkedés adattagja.
Tartalmaz egy getDistanceFrom(TrackPoint point) metódust mely, egy másik ponttól vett távolságot adja vissza.
A földrajzi koordinátákkal való számoláshoz segítségül:
 */

package activity;

public class TrackPoint {

    private Coordinate coordinate;

    private double elevation;

    public TrackPoint(Coordinate coordinate, double elevation) {
        this.coordinate = coordinate;
        this.elevation = elevation;
    }

//    public double getDistanceFrom(TrackPoint point) {
//        // egy másik ponttól vett távolságot adja vissza
//
//    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public double getElevation() {
        return elevation;
    }

}
