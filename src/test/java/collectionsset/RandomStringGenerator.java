package collectionsset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class RandomStringGenerator {

    public Collection<String> createStrings(int length, int numberOfElements) {
        Collection<String> collection = new ArrayList<>();
        for (int i = 0; i < numberOfElements; i++) {
            collection.add(randomString(length));
        }
        return collection;
    }

    private String randomString(int length) {
        StringBuilder sb = new StringBuilder("");     // StringBuilder, mert mutable
        Random rnd = new Random();                    // pseudorandom számot generál
        for (int i = 0; i < length; i++) {
            int code = rnd.nextInt('z' - 'a');  // 122 - 97 = 25 -> 0 és 25 között generál egy véletlen számot
            code += 'a';                              // hozzáadja 'a' karakterkódját -> 97 és 122 között ad egy számot
            char x = (char) code;                     // ezt a számot explicit konvertálja karakterré
            sb.append(x);                             // SringBuilder metódus, összefűzi a véletlen karakter sorozatot
        }
        return sb.toString();                         // SB-t Stringgé konvertálja
    }
}