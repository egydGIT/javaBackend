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



    /*

    private final String pageContent;
    private final String pageColour;
    private PageColour pageColour;

    public ColoredPage(String pageContent, PageColour pageColour) {
        this.pageContent = pageContent;
        this.defaultPageColour = null;
        this.pageColour = pageColour;
    }

    public ColoredPage(String pageContent) {
        this.pageContent = pageContent;
        this.defaultPageColour = Printable.DEFAULT_COLOUR_BLACK;
        this.pageColour = null;
    }

    de akkor getter-t mire?
    ez talán csak akkor jó, ha a default szín is az enumban van, nem az interfészben.
     */
}
