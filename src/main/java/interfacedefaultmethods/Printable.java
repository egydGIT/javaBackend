package interfacedefaultmethods;

public interface Printable {                            // Dependency inversion: NewsPaper, StoryBook

    String DEFAULT_COLOUR_BLACK = "#000000";

    int getLength();

    String getPage(int pageNumber);

    default String getColor(int pageNumber) {
        return DEFAULT_COLOUR_BLACK;
    }



}
