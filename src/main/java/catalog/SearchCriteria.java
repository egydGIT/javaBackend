/*
SearchCriteria osztály: Egy immutable osztály melynek attribútumai egy cím és egy szerző.
Az osztályt úgy kell megvalósítani, hogy akár cím, akár szerző alapján, sőt mindkettő alapján lehessen keresni
a katalógusban (statikus metódusokkal lehet létrehozni).
 */

package catalog;

public class SearchCriteria {

    public final String contributor;

    public final String tile;

    public SearchCriteria(String contributor, String tile) {
        this.contributor = contributor;
        this.tile = tile;
    }

//    public SearchCriteria createByBoth(String contributor, String tile) {
//
//    }
//
//    public SearchCriteria createByContributor(String contributor) {
//
//    }
//
//    public SearchCriteria createByTitle(String tile) {
//
//    }
//
//    public boolean hasContributor() {
//
//    }
//
//    public boolean hasTitle() {
//
//    }
//
//    private void SearchCriteria(String contributor, String tile) {
//
//    }

    public String getContributor() {
        return contributor;
    }

    public String getTile() {
        return tile;
    }
}
