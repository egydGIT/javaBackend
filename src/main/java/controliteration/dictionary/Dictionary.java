package controliteration.dictionary;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {

    private List<DictionaryItem> dictionaryItems = new ArrayList<>();

    public void addItem(String word, List<String> translations) {       // új fordítások felvételére
        boolean found = false;                                          // boolean változó definiálása, értéke false
        for (DictionaryItem item: dictionaryItems) {                    // DictionaryItem tipusú item nevű változó
                                                                             // végigiterál a dictionaryItems objektumon
            if (item.getWord().equals(word)) {                          // ha akt értékre a getWord met-sal lekért érték
                                                                             // megegyezik a param-ként átadott szóval
                item.addTranslations(translations);                     // akkor addTranslations met-sal adja hozzá
                                                                             // translations listát
                found = true;                                           // találat ekkor igazzá válik
            }
        }

        if (!found) {                                                   // ha találat megmarad false = nincs találat
            dictionaryItems.add(new DictionaryItem(word, translations)); // dictionaryItems obj-hoz adja hozzá az új
                                                                                // szó + fordítás lepéldányosított obj-t
        }

    }

    public List<String> findTranslations(String word) {
        for (DictionaryItem item: dictionaryItems) {                    // ha a DictionaryItem obj-ban
            if (item.getWord().equals(word)) {                          // megtalálja a szót
                return item.getTranslations();                          // adja vissza a fordítási listát
            }
        }
        return new ArrayList<>();                                       // térjen vissza a szóhoz tartozó listával
    }
}
