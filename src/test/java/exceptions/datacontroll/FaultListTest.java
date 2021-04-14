package exceptions.datacontroll;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class FaultListTest {

    private static final List<String> INPUT = Arrays.asList(
            "1,12.4,1998.04.12.",
            "2,12.4,1998.04.12.,a",
            "a,12.4,1998.04.12.",
            "3,12a.4,1998.04.12.",
            "4,12.4,1998.12.1.",
            "5,12.4,1998.04.3a.",
            "a1,12a.4,1998.04.12.",
            "6,12a.4,1998.04a.12.");


    @Test
    public void processingNullParamShouldThrowException() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> new FaultList().processLines(null));
    }

    @Test
    public void processing() {
        FaultList faultList = new FaultList();
        List<String> faults = faultList.processLines(INPUT);

        List<String> expected = new ArrayList<>();
        expected.add("2," + Results.WORD_COUNT_ERROR.getCode());
        expected.add("3," + Results.VALUE_ERROR.getCode());
        expected.add("5," + Results.DATE_ERROR.getCode());
        expected.add("6," + Results.VALUE_AND_DATE_ERROR.getCode());

        assertEquals(expected, faults);
    }

}