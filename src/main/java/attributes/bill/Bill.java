package attributes.bill;

import java.util.ArrayList;
import java.util.List;

public class Bill {
    List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public double calculateTotalPrice() {
        double sum = 0;
        for ( Item item : items ) {
            sum = sum + (item.getPrice() * item.getQuantity());
        }
        return sum;
    }
/*
    @Override
    public String toString() {
        return "Bill{" +
                "items=" + items +
                '}';
    }

 */

    public List<Item> getItems() {                          // Nem sikerül kiiratni...
        return items;
    }

/*
    public Item getItems() {
        for (int j = 0; j < items.size(); j++) {
            System.out.println(items.get(j).toString());
        }
        return (Item) items;
    }

 */
}
