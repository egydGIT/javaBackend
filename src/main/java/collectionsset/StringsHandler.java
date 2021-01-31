package collectionsset;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class StringsHandler {

    public Set<String> filterUniqueStrings(Collection<String> stringCollection) {  // kiszűri az egyedi elemeket
        Set<String> uniqueStrings = new HashSet<>(stringCollection);               // Set-ben nem lehet duplikáció
        return uniqueStrings;
    }

    public Set<String> selectIdenticalStrings(Set<String> setA, Set<String> setB) {  // két különböző String halmazból kinyeri a közös elemeket.
        setA.retainAll(setB);
        // If the specified collection is also a set, this operation effectively modifies this set
        // so that its value is the intersection of the two sets.
        return setA;
    }

}
