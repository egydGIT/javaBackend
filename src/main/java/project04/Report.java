/*
Report osztály: Egy immutable osztály melynek egy típus és egy távolság adattagja van.
 */

package project04;

public class Report {

    private final ActivityType activityType;

    private final boolean distance;

    public Report(ActivityType activityType, boolean distance) {
        this.activityType = activityType;
        this.distance = distance;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public boolean isDistance() {
        return distance;
    }

}
