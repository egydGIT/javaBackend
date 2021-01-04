package week05d04;

import java.util.ArrayList;
import java.util.List;

public class Store {
    /*
    Készíts egy Store osztályt, melyben van egy Product-okat tároló lista.
    Legyen benne egy addProduct(Product) metódus!

    Bónusz: Legyen benne egy getNumberOfExpired() metódus ami visszaadja a lejárt termékek számát!
    Használd a LocalDate.now() és az isBefore() metódusokat!
     */

    private List<Product> listOfProducts = new ArrayList<>();
    private Product product;

    public List<Product> addProduct(Product product) {           // Product... productOther ??
        listOfProducts.add(product);
        return listOfProducts;
    }

    public List<Product> getListOfProducts() {
        return listOfProducts;
    }


    public static void main(String[] args) {
        Product product1 = new Product("tej", 2021, 01, 10);
        Product product2 = new Product("sajt", 2021, 01, 5);
        Product product3 = new Product("tejföl", 2021, 01, 2);

        Store store = new Store();
        store.addProduct(product1);
        store.addProduct(product2);
        store.addProduct(product3);
        System.out.println(store.getListOfProducts());
        System.out.println(store.getListOfProducts().get(2));


    }
}
