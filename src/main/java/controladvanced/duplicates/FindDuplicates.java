package controladvanced.duplicates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDuplicates {
/*
    public Integer findDuplicate(List<Integer> manyNumbers) {           // Nem jó. Csak az utólsót irja ki és túl is fut
        Integer findDuplicate = 0;
        for ( int i = 0; i <= manyNumbers.size(); i++) {
            for (int j = 0; j <= manyNumbers.size(); j++) {
                if ( manyNumbers.get(i).equals(manyNumbers.get(j))) {
                    findDuplicate = manyNumbers.get(i);
                    System.out.println(findDuplicate);
                }
            }
        }
        return findDuplicate;
    }

 */



    public List<Integer> find(List<Integer> manyNumbers) {                  // Solution
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < manyNumbers.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (manyNumbers.get(i).equals(manyNumbers.get(j))) {
                    result.add(manyNumbers.get(i));
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> manyNumbers = Arrays.asList(20, 21, 22, 23, 21, 24, 25, 26, 24, 27, 28, 20);

        // System.out.println(new FindDuplicates().findDuplicate(manyNumbers));

        System.out.println(new FindDuplicates().find(manyNumbers));

    }
}
