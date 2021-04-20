package collectionsautoboxing;

import java.util.ArrayList;
import java.util.List;

public class IntegerOperations {

    public List<Integer> createList(int... numbers) {
        List<Integer> numbersList = new ArrayList<>();
        for (int n: numbers) {
            numbersList.add(n);
        }
        return numbersList;
    }

    public int sumIntegerList(List<Integer> integerList) {
        int sum = 0;
        for (int i: integerList) {
            sum += i;
        }
        return sum;
    }

    public int sumIntegerObjects(Integer... integers) {
        int sum = 0;
        for (Integer i: integers) {
            sum += i;
        }
        return sum;
    }


}
