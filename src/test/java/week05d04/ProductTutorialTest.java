package week05d04;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTutorialTest {

    @Test
    public void addProduct() {
        List<ProductTutorial> testList = new ArrayList<>();
        StoreTutorial store = new StoreTutorial(testList);
        store.addProduct(new ProductTutorial("milk", 2021, 1, 2));
        assertEquals("milk", testList.get(0).getName());
    }

    @Test
    public void TestGetNumberOfExpired() {
        List<ProductTutorial> testList = new ArrayList<>();
        StoreTutorial store = new StoreTutorial(testList);
        store.addProduct(new ProductTutorial("milk", 2021, 1, 2));
        store.addProduct(new ProductTutorial("bread", 2021, 1, 10));
        assertEquals(1, store.getNumberOfExpired());                                 // futtatva: 2021.01.04
    }
}
