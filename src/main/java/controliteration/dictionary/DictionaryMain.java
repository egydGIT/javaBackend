package controliteration.dictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DictionaryMain {

    public static void main(String[] args) {
        DictionaryItem dictionaryItem1 = new DictionaryItem("ékezet", Arrays.asList("accent"));
        DictionaryItem dictionaryItem2 = new DictionaryItem("mássalhangzó", Arrays.asList("consonant"));

        System.out.println(dictionaryItem1.getWord());
        System.out.println(dictionaryItem1.getTranslations());

        Dictionary dictionary = new Dictionary();

        dictionary.addItem("ékezet", Arrays.asList("accent"));
        dictionary.addItem("mássalhangzó", Arrays.asList("consonant"));

        System.out.println(dictionary.findTranslations("ékezet"));

        // új translation felvétele ??

    }

}
// alveolar
