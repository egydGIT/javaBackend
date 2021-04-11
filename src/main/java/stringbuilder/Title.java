package stringbuilder;

public enum Title {
    DR("Dr."),
    PROF("Prof."),
    MR("Mr."),
    MRS("Mrs."),
    MS("Ms.");

    private String titleString;

    Title(String titleString) {
        this.titleString = titleString;
    }

    public String getTitleString() {
        return titleString;
    }
}
