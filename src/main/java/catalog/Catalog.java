/*
Catalog osztály: A katalógus tartalmazza a katalógus elemek listáját és ebben az osztályban lehet
különböző lekérdezéseket végrehajtani. Le lehet kérdezni:

Az audio illetve nyomtatott jellemzőkkel rendelkező elemeket (getAudioLibraryItems(), getPrintedLibraryItems())
Az összoldalszámot a nyomtatottaknál (getAllPageNumber())
Az összhosszt az audio típusúaknál (getFullLength())
Az átlag oldalszámot egy bizonyos oldalszám felett (averagePageNumberOver())
Keresni lehet egy SearchCriteria alapján (lásd lejjebb) (findByCriteria())

 */

package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    private List<String> catalogItems = new ArrayList<>();

//    public void addItem(CatalogItem catalogItem) {
//
//    }
//
//    public double averagePageNumberOver() {
//
//    }
//
//    public void deleteItemByRegistrationNumber() {
//
//    }
//
//    public List<CatalogItem> findByCriteria(SearchCriteria searchCriteria) {
//
//    }
//
//    public int getAllPageNumber() {
//
//    }
//
//    public List<CatalogItem> getAudioLibraryItems() {
//
//    }
//
//    public int getFullLength() {
//
//    }
//
//    public List<CatalogItem> getPrintedLibraryItems() {
//
//    }
}
