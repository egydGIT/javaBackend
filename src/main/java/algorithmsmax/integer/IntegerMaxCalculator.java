package algorithmsmax.integer;

import java.util.Arrays;
import java.util.List;

public class IntegerMaxCalculator {
    public int integerMaxCalculator(List<Integer> numbers) {
        int max = 0;
        for (Integer n: numbers) {
            if (n > max) {
                max = n;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(28, 75, 96, 48, 25, 36, 10, 98, 43);

        System.out.println(new IntegerMaxCalculator().integerMaxCalculator(numbers));

    }
}
