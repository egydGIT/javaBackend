package interfacedefaultmethods;

import java.util.ArrayList;
import java.util.List;

public class NewsPaper implements Printable {

    private List<String> newsPaperPages = new ArrayList<>();

    @Override
    public int getLength() {
        return newsPaperPages.size();
    }

    @Override
    public String getPage(int pageNumber) {
        return newsPaperPages.get(pageNumber);
    }

    public void addPage(String pageContent) {
        newsPaperPages.add(pageContent);
    }
}
