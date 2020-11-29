package controliteration.dictionary;

import java.util.ArrayList;
import java.util.List;

public class DictionaryItem {
    private String word;

    private List<String> translations = new ArrayList<>();

    public DictionaryItem(String word, List<String> translations) {     // Konstruktor
        this.word = word;
        addTranslations(translations);                              // this.translations = translations;  ez is jó lenne
    }

    public void addTranslation(String newTranslation) {             // Egy szót ad hozzá meglévő fordításhoz
        for (String translation : translations) {
            if (!translation.contains(newTranslation)) {
                translations.add(newTranslation);
            }
        }
    }

    public void addTranslations(List<String> newTranslations) {     // Több szót ad hozzá meglévő fordításhoz
        for (String newTranslation: newTranslations) {              // newTranslation változó végiglépked
                                                                            // a newTranslations listán
            if (!translations.contains(newTranslation)) {           // ha a translations lista nem tartalmazza a
                                                                            // newT vált aktuális értékét
                translations.add(newTranslation);                   // akkor adja hozzá
            }
        }
    }

    public String getWord() {
        return word;
    }

    public List<String> getTranslations() {
        return translations;
    }

    @Override
    public String toString() {
        return "DictionaryItem{" +
                "word='" + word + '\'' +
                ", translations=" + translations +
                '}';
    }
}
