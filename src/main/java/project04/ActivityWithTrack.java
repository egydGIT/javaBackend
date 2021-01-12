/*
ActivityWithTrack osztály: Implementálja az Activity interface-t.
Van egy Track addattagja. A getDistance() metódus a megadott track össztávolságát adja vissza míg a getType() a típust.
 */

package project04;

public class ActivityWithTrack implements Activity{

    private ActivityType activityType;

    private Track track;

    public ActivityWithTrack(ActivityType activityType, Track track) {
        this.activityType = activityType;
        this.track = track;
    }

    @Override
    public double getDistance() {
        return 0;
    }

    @Override
    public ActivityType getType() {
        //return null;
    }
}
