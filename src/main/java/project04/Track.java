/*
Track osztály: TrackPoint-ok listáját tárolja. Le lehet kérdezni az összemelkedést, az össztávolságot.
Valamint a pontokat, mint függvényt elképzelve a bennfoglaló téglalap területét.

Írj egy loadFromGpx() metódust is, mely egy szabványos GPX fájlt tölt be!
Itt azt figyeld, hogy a sor a <trkpt és <ele szöveggel kezdődik-e!
Itt beégetheted, hogy a számok hanyadik karaktertől hanyadik karakterig tartanak.
Egy Coordinate példányt hozz létre, ha belefutsz a <trkpt sorba!
Egy TrackPoint példányt hozz létre, ha belefutsz a <ele sorba, és add hozzá a listához!
Egy példa állományt az src/test/resources könyvtárban találsz.
 */

package project04;

import java.util.ArrayList;
import java.util.List;

public class Track {

    private List<TrackPoint> trackPoints = new ArrayList<>();

    private double distance;
    private double fullDecrease;
    private double fullElevation;
    private double rectangleArea;

    public void addTrackPoint(TrackPoint) {

    }

    public Coordinate findMinimumCoordinate() {

    }

    public Coordinate findMaximumCoordinate() {

    }

    public .. loadFromGpx() {
        // féjlbetöltés
    }

    public List<TrackPoint> getTrackPoints() {
        return trackPoints;
    }

    public double getDistance() {
        return distance;
    }

    public double getFullDecrease() {
        return fullDecrease;
    }

    public double getFullElevation() {
        return fullElevation;
    }

    public double getRectangleArea() {
        return rectangleArea;
    }
}
