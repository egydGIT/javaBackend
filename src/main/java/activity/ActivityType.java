/*
ActivityType enum: Négy féle típus lehet: BIKING,HIKING,RUNNING,BASKETBALL. Fontos, hogy ebben a sorrendben.
 */

package activity;

public enum ActivityType {
    BIKING("Biking"), HIKING("Hiking"), RUNNING("Running"), BASKETBALL("Basketball");

    String type;

    ActivityType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }


}
