package interfacestaticmethods;

import java.util.List;

public interface Valued {

    double getValue();

    static int sumMy(List<Valued> values) {
        int sum = 0;
        for (int i = 0; i < values.size(); i++) {
            sum += values.get(i).getValue();
        }
        return sum;
    }

    static double totalValue(List<Valued> items) {
        double result = 0;
        for (Valued valued : items) {
            result += valued.getValue();
        }
        return result;
    }

}
