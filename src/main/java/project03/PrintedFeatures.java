/*
PrintedFeatures osztály: Ez az osztály jellemez egy katalóguselemet, ha az nyomtatott tulajdonságokkal rendelkezik.
A nyomtatott jellemzők a cím, az oldalszám, illetve a szerzők. Szintén a Feature-t implementálja.
A getContributors() itt a szerzőket adja vissza listaként.
 */

package project03;

import java.util.List;

public class PrintedFeatures implements Feature{

    private List<String> authors;

    private int numberOfPages;

    private String tittle;

    public PrintedFeatures(List<String> authors, int numberOfPages, String tittle) {
        this.authors = authors;
        this.numberOfPages = numberOfPages;
        this.tittle = tittle;
    }

    @Override
    public List<String> getContributors() {
        return null;
    }

    @Override
    public String getTitle() {
        return null;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }
}
