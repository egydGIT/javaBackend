package interfacestaticmethods;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValuedTest {

    @Test
    void testSumMy() {
        SomethingWithValue swv1 = new SomethingWithValue("picture1", 500);
        SomethingWithValue swv2 = new SomethingWithValue("picture2", 350);
        SomethingWithValue swv3 = new SomethingWithValue("picture3", 780);

        List<Valued> withValues = new ArrayList<>();
        withValues.add(swv1);
        withValues.add(swv2);
        withValues.add(swv3);

        assertEquals(1630, Valued.sumMy(withValues));

    }

    @Test
    public void testSum() {

        List<Valued> items = List.of(new Product("apple", 0.5),
                new Product("book", 2.1),
                new Product("printer", 18.9));

        assertEquals(0.000001, 21.5, Valued.totalValue(items));
    }

}