package stringconcat.stringconcat;

public enum Title {
    DR("Dr"),
    MR("Mr"),
    MRS("Mrs"),
    MS("Ms");
    // NOTHING("");

    private String titleString;

    Title(String titleString) {
        this.titleString = titleString;
    }

    public String getTitleString() {
        return titleString;
    }
}
