/*
Activities osztály: Activity-k listáját tartalmazza.
Le lehet kérdezni a track-es illetve a track nélküli listaelemeket.
Valamint típusonként külön-külön a távolságot egy Report-okat tartalmazó listába.
 */

package activity;

import java.util.ArrayList;
import java.util.List;

public class Activities {

    private List<Activity> activities = new ArrayList<>();

    public Activities(List<Activity> activities) {
        this.activities = activities;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }
/*
    public List<Report> distancesByTypes() {

    }

    public int numberOfTrackActivities() {

    }

    public int numberOfWithoutTrackActivities() {

    }

 */

}
