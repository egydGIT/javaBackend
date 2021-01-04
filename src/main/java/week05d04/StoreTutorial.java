package week05d04;

import java.util.ArrayList;
import java.util.List;

public class StoreTutorial {

    private List<ProductTutorial> products = new ArrayList<>();
    private ProductTutorial productTutorial;

    public StoreTutorial(List<ProductTutorial> products) {
        this.products = products;
    }

    public boolean addProduct(ProductTutorial product) {
        if(isValid(product)) {
            return false;
        }
        products.add(product);
        return true;
    }

    public int getNumberOfExpired() {
        int count = 0;
        for (ProductTutorial p: products) {
            if (p.isExpired()) {
                count++;
            }
        }
        return count;
    }

    private boolean isValid(ProductTutorial product) {
        if (containsByName(product) || product.isExpired()) {
            return false;
        }
        return true;
    }

    private boolean containsByName(ProductTutorial product) {
        for (ProductTutorial p: products) {
            if (p.getName().equals((product.getName()))) {
                return true;
            }
        }
        return false;
    }
}
