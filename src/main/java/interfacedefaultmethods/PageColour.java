package interfacedefaultmethods;

public enum PageColour {                    // ColoredPage oszt-ban lehetne has-a kapcsolattal
    RED("#FF0000");

    private String pageColour;

    PageColour(String pageColour) {
        this.pageColour = pageColour;
    }

    public String getPageColour() {
        return pageColour;
    }


}
