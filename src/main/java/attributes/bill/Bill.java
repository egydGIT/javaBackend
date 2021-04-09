package attributes.bill;

import java.util.ArrayList;
import java.util.List;

public class Bill {
    private List<Item> items = new ArrayList<>();

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

    public List<Item> getItems() {
        return items;
    }

    public List<String> getItemNames() {
        List<String> itemNames = new ArrayList<>();
        for (int j = 0; j < items.size(); j++) {
            itemNames.add(items.get(j).getProduct());
        }
        return itemNames;
    }


}
