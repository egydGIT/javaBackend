package algorithmsmax.salesperson;

import algorithmsmax.salesperson.SalesPerson;
import algorithmsmax.salesperson.SalesPersonSelector;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalesPersonTest {

    @Test
    public void testCreateIsOk() {
        SalesPerson person = new SalesPerson("Somebody", 1000, 200);

        assertEquals(1000, person.getAmount());
        assertEquals(200, person.getTarget());
        assertEquals(800, person.getDifferenceFromTarget());
    }

    List<SalesPerson> salespersons = Arrays.asList(
            new SalesPerson("John", 600, 500),
            new SalesPerson("Bill", 200, 300),
            new SalesPerson("Kate", 700, 100),
            new SalesPerson("Mary", 700, 300),
            new SalesPerson("Karl", 200, 50)
    );

    @Test
    public void testSelectSalesPersonWithMaxSalesAmount() {
        SalesPersonSelector maxAmount = new SalesPersonSelector();

        assertEquals(700, maxAmount.maxReceipts(salespersons).getAmount());
        assertEquals(100, maxAmount.maxReceipts(salespersons).getTarget());
    }

    @Test
    public void testSelectSalesPersonWithFurthestAboveTarget() {
        SalesPersonSelector aboveTarget = new SalesPersonSelector();

        assertEquals(600, aboveTarget.maxLargerThanTarget(salespersons).getDifferenceFromTarget());
        assertEquals(700, aboveTarget.maxLargerThanTarget(salespersons).getAmount());
        assertEquals(100, aboveTarget.maxLargerThanTarget(salespersons).getTarget());
    }

    @Test
    public void testSelectSalesPersonWithFurthestBelowTarget() {
        SalesPersonSelector belowTarget = new SalesPersonSelector();

        assertEquals(-100, belowTarget.maxLesserThanTarget(salespersons).getDifferenceFromTarget());
        assertEquals(200, belowTarget.maxLesserThanTarget(salespersons).getAmount());
        assertEquals(300, belowTarget.maxLesserThanTarget(salespersons).getTarget());
    }


}