package introinheritance.itembasketshoppingb;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private List<Item> items = new ArrayList<>();

    public Basket() {
    }

    public Basket(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(String barcode) {
        Item findItem = null;
        for (Item item: items) {
            if (item.getBarcode().equals(barcode)) {
                findItem = item;
            }
        }
        items.remove(findItem);
    }

    public void clearBasket() {
        // items.remove(items);
        items.clear();
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }

    public List<Item> getItemsNotNew() {                // main miatt
        return items;
    }

    @Override                                           // main miatt
    public String toString() {
        return items.toString();
    }
}
