package activity;

import java.util.ArrayList;
import java.util.List;

public class Track {

    private List<TrackPoint> trackPoints = new ArrayList<>();

    private double distance;
    private double fullDecrease;
    private double fullElevation;
    private double rectangleArea;

    public void addTrackPoint(TrackPoint trackPoint) {
        trackPoints.add(trackPoint);
    }

//    public Coordinate findMinimumCoordinate() {
//
//    }
//
//    public Coordinate findMaximumCoordinate() {
//
//    }
//
//    public .. loadFromGpx() {
//        // féjlbetöltés
//    }


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
