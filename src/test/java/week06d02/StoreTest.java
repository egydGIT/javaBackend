package week06d02;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreTest {

    @Test
    void testGetProductByCategoryName() {
        Product product1 = new Product("milk", "dairy");
        Product product2 = new Product("chocolate", "sweet");
        Product product3 = new Product("ice-cream", "sweet");
        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);

        assertEquals(2, new Store(products).getProductByCategoryName("sweet"));
    }
}
