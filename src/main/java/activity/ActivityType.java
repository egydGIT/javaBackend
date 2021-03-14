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
