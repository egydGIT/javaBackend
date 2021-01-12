/*
AudioFeatures osztály: Ez az osztály jellemez egy katalóguselemet, ha az audio tulajdonságokkal rendelkezik.
Ilyen a zenei album és hangoskönyv. Minden audio elemnek van címe, hossza, előadói, illetve szerzői.
Implementálja a Feature interface-t. A szerzők megadása nem kötelező (két konstruktor szükséges, overload).
A getContributors() metódus a szerzők és előadók közös listájával tér vissza.
 */

package project03;

import java.util.List;

public class AudioFeatures implements Feature {

    private List<String> composer;

    private final int length;

    private final List<String> performers;

    private final String title;

    public AudioFeatures(List<String> composer, int length, List<String> performers, String title) {
        this.composer = composer;
        this.length = length;
        this.performers = performers;
        this.title = title;
    }

    public AudioFeatures(int length, List<String> performers, String title) {
        this.length = length;
        this.performers = performers;
        this.title = title;
    }

    @Override
    public List<String> getContributors() {
        return null;
    }

    @Override
    public String getTitle() {
        return null;
    }

    public int getLength() {
        return length;
    }


}
