/*
CatalogItem osztály: Minden katalógus elemnek van egy jellemzők listája melyek lehetnek akár nyomtatottak vagy audio-k.
Továbbá minden katalógus elemnek van ára és egy regisztrációs száma.
 */

package project03;

import java.util.ArrayList;
import java.util.List;

public class CatalogItem {

    private List<Feature> features = new ArrayList<>();

    private final int price;

    private final String registrationNumber;

    public CatalogItem(List<Feature> features, int price, String registrationNumber) {
        this.features = features;
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

//    public int fullLengthAtOneItem() {
//
//    }
//
//    public List<String> getContributors() {
//        return null;
//    }
//
//    public String getTitle() {
//        return null;
//    }
//
//    public boolean hasAudioFeature() {
//
//    }
//
//    public boolean hasPrintedFeature() {
//
//    }
//
//    public int numberOfPagesAtOneItem() {
//
//    }

    public List<Feature> getFeatures() {
        return features;
    }

    public int getPrice() {
        return price;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}
