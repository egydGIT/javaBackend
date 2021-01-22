package interfacedefaultmethods;

public class ColoredPage {                      // immutable!

    private final String pageContent;

    private final String pageColour;

    public ColoredPage(String pageContent, String pageColour) {
        this.pageContent = pageContent;
        this.pageColour = pageColour;
    }

    public ColoredPage(String pageContent) {
        this.pageContent = pageContent;
        this.pageColour = Printable.DEFAULT_COLOUR_BLACK;
    }

    public String getPageContent() {
        return pageContent;
    }

    public String getPageColour() {
        return pageColour;
    }


}
