package week05d04;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    @Test
    void testAddProduct() {
        Store store = new Store();
        List<Product> listOfProducts = store.addProduct(new Product("tej", 2021, 1, 4));
        assertEquals(1, listOfProducts.size());
        assertEquals("tej", listOfProducts.get(0).getName());
    }
}
