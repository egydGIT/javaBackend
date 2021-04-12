package introinheritance.itembasketshoppingb;

import java.util.ArrayList;
import java.util.List;

public class ShoppingBasket {
    private Basket basket = new Basket();

    public ShoppingBasket() {
    }

    public ShoppingBasket(Basket basket) {
        this.basket = basket;
    }

    public void addItem(Item item) {
        basket.addItem(item);
    }

    public void removeItem1(String barcode) {           // fölösleges 2x leírni, ha a basket-en keresztül meg lehet hívni
        Item findItem = null;
        for (Item item: basket.getItems()) {
            if (item.getBarcode().equals(barcode)) {
                findItem = item;
            }
        }
        basket.getItemsNotNew().remove(findItem);
    }

    public void removeItem2(String barcode) {
        basket.removeItem(barcode);
    }

    public double sumNettoPrice() {        // Összegzés tétele
        double sumNetto = 0.0;
        for (Item item : basket.getItems()) {
            sumNetto += item.getNettoPrice();
        }
        return sumNetto;
    }

    public double sumTaxValue() {           // Összegzés tétele
        double sumTax = 0.0;
        for (Item item : basket.getItems()) {
            sumTax += item.getTaxAmount();
        }
        return sumTax;
    }

    public double sumBruttoPrice() {
        return sumNettoPrice() + sumTaxValue();
    }

    public void checkout() {
        basket.clearBasket();
    }

    public void removeMostExpensiveItem() {
        removeItem2(getMostExpensiveItemBarcode());
    }

    public String getMostExpensiveItemBarcode() {     // Szélsőértékkeresés tétele objektumon
        Item mostExpensive = null;
        for (Item item : basket.getItems()) {
            if (mostExpensive == null || item.getNettoPrice() > mostExpensive.getNettoPrice()) {
                mostExpensive = item;
            }
        }
        return mostExpensive.getBarcode();
    }


    @Override                                   // main miatt
    public String toString() {
        return basket.toString();
    }

    public static void main(String[] args) {
        Item item1 = new Item("123", 4000.0, 27);
        Item item2 = new Item("456", 530.0, 27);
        Item item3 = new Item("789", 1500.0, 27);

        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);

        System.out.println("items: " + items);

        Basket basket = new Basket(items);

        ShoppingBasket shoppingBasket = new ShoppingBasket(basket);
        // mostExpensive
        System.out.println("getMostExpensive: " + shoppingBasket.getMostExpensiveItemBarcode());

        // árak:
        System.out.println("sumNettoPrice: " + shoppingBasket.sumNettoPrice());
        System.out.println("sumTaxValue: " + shoppingBasket.sumTaxValue());
        System.out.println("sumBruttoPrice: " + shoppingBasket.sumBruttoPrice());

        // removeItem1
        shoppingBasket.removeItem1("456");
        System.out.println("remove 456: " + shoppingBasket);
        // removeItem2
        shoppingBasket.removeItem2("789");
        System.out.println("remove 789: " + shoppingBasket);

        // clear
        basket.clearBasket();
        System.out.println("clear: " + items);



    }


}
