package debug.numbers;

import java.util.Arrays;
import java.util.List;

public class NumberStatistics {
    private List<Integer> numbers;

    public NumberStatistics(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int sumPositives() {
        int sum = 0;
        for(int n: numbers) {                                            // nem kell ehhez debug:
            if(n != 0) {                                                 // != helyett >
                sum += n;
            }
        }
        return sum;
    }

    public int minDifferenceBetweenNeighbours() {
        int minDifference = numbers.get(0) - numbers.get(1) >= 0 ? numbers.get(0) - numbers.get(1) : numbers.get(1) - numbers.get(0);
        for(int i = 1; i < numbers.size() - 1; i++) {
            int actDifference = numbers.get(i) - numbers.get(i + 1);     // hiányzik a 3 operandusos kif v. absz érték
            if(actDifference < minDifference) {
                minDifference = actDifference;
            }
        }
        return minDifference;
    }

    public static void main(String[] args) {
        /*
        new NumberStatistics(Arrays.asList(4, 8, -1, -2, 4, 5, 3)).sumPositives() --> 24
        new NumberStatistics(Arrays.asList(4, 8, -1, -2, 4, 5, 3)).minDifferenceBetweenNeighbours() --> 1
        new NumberStatistics(Arrays.asList(-3, -4)).sumPositives() --> 0
        new NumberStatistics(Arrays.asList(1)).minDifferenceBetweenNeighbours() --> IllegalStateException

         */

        NumberStatistics statistics = new NumberStatistics(Arrays.asList(4, 8, -1, -2, 4, 5, 3));
        int sum = statistics.sumPositives();
        int minDifference = statistics.minDifferenceBetweenNeighbours();
        System.out.println("Sum: " + sum);
        System.out.println("Minimal difference between neighbours: " + minDifference);

        NumberStatistics statistics2 = new NumberStatistics(Arrays.asList(-3, -4));
        int sum2 = statistics2.sumPositives();
        System.out.println("Sum 2: " + sum2);

        NumberStatistics statistics3 = new NumberStatistics(Arrays.asList(1));
        statistics3.minDifferenceBetweenNeighbours();  //Should throw IllegalStateException

    }

}

}

