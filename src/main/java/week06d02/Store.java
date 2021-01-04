package week06d02;

import java.util.ArrayList;
import java.util.List;

public class Store {
    /*
    Junior
    Hozz létre egy Product osztályt melynek adattagjai a név, kategória és ár, rendre String, String int!
    Készíts egy Store osztályt benne egy Product listával, amit konstruktorban kap meg.
    Legyen egy getProductByCategoryName(Category), ami visszaadja,
    hogy a paraméterül kapott kategóriából hány darab van a listában!
    Bónusz: A kategória legyen enum FROZEN, DAIRY, BAKEDGOODS, OTHER felsorolókkal!
     */

    private List<Product> products = new ArrayList<>();
    private Product product;

    public Store(List<Product> products) {
        this.products = products;
    }

    public int getProductByCategoryName(String category) {
        int counter = 0;
        for (Product p: products) {
            if (p.getCategory().equals(category)) {
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        Product product1 = new Product("milk", "dairy");
        Product product2 = new Product("chocolate", "sweet");
        Product product3 = new Product("ice-cream", "sweet");
        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        Store store = new Store(products);
        System.out.println(store.getProductByCategoryName("sweet"));

    }
}
