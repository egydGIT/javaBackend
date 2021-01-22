package interfacestaticmethods;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValuedTest {

    @Test
    void testSum() {
        SomethingWithValue swv1 = new SomethingWithValue("picture1", 500);
        SomethingWithValue swv2 = new SomethingWithValue("picture2", 350);
        SomethingWithValue swv3 = new SomethingWithValue("picture3", 780);

        List<Valued> withValues = new ArrayList<>();
        withValues.add(swv1);
        withValues.add(swv2);
        withValues.add(swv3);

        assertEquals(1630, Valued.sum(withValues));

    }

}