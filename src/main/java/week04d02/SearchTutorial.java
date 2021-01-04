package week04d02;

import java.util.ArrayList;
import java.util.List;

public class SearchTutorial {

    public List<Integer> getPositionOfChar(String base, String part) {   // Ha nem csak Char értéket keres
        List<Integer> result = new ArrayList<>();
        int lengthMinusPart = base.length() - part.length() +1;          // magyarázat alapján kiegészítve
        for ( int i = 0; i < lengthMinusPart; i++) {
            if (base.toLowerCase().substring(i, i + part.length()).equals(part.toLowerCase())) {   // +toLowerCase
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SearchTutorial searchTutorial = new SearchTutorial();
        System.out.println(searchTutorial.getPositionOfChar("getPositionOfChar", "iti"));
        System.out.println(searchTutorial.getPositionOfChar("getPositionOfChar", "char"));
        System.out.println(searchTutorial.getPositionOfChar("getPositionOfChar", "somethingElse"));
    }
}
