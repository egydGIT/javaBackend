package algorithmssum.sales;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumAllSalesAmountTest {

    @Test
    public void testSumSalesAmount() {
        SumAllSalesAmount test = new SumAllSalesAmount();

        List<Salesperson> salespersons = Arrays.asList(
                new Salesperson("John", 600),
                new Salesperson("Bill", 200),
                new Salesperson("Kate", 700),
                new Salesperson("Mary", 700),
                new Salesperson("Karl", 200)
        );

        assertEquals(2400,test.sumAllSalesAmount(salespersons));

    }

}