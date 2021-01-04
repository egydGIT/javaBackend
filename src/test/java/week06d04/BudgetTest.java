package week06d04;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BudgetTest {

    @Test
    void testGetItemsByMonth() {
        List<Item> items = Arrays.asList(new Item(500, 2, "pen"),
                new Item(600, 5, "pencil"),
                new Item(200, 2, "eraser"));
        Budget budget = new Budget(items);

        assertEquals(2, budget.getItemsByMonth(2).size());
        assertEquals("pen", budget.getItemsByMonth(2).get(0).getName());
    }
}
