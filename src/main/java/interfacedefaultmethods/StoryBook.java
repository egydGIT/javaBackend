package interfacedefaultmethods;

import java.util.ArrayList;
import java.util.List;

public class StoryBook implements Printable{

    private List<ColoredPage> storyBookPages = new ArrayList<>();

    @Override
    public int getLength() {
        return storyBookPages.size();
    }

    @Override
    public String getPage(int pageNumber) {
        return storyBookPages.get(pageNumber).getPageContent();
    }

    @Override
    public String getColor(int pageNumber) {
        return storyBookPages.get(pageNumber).getPageColour();
    }

    public void addPage(String page, String color) {
        storyBookPages.add(new ColoredPage(page, color));
    }


}
