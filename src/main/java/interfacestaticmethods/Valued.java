package interfacestaticmethods;

import java.util.List;

public interface Valued {

    int getValue();

    static int sum(List<Valued> values) {
        int sum = 0;
        for (int i = 0; i < values.size(); i++) {
            sum += values.get(i).getValue();
        }
        return sum;
    }
}
