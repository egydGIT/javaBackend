package week06d04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Budget {

    /*
    Junior
    Készíts az egy Budget osztályt, amely a konstruktorában Item példányokat vár listában (List).
    Az Item tartalmazza az alábbi attribútumokat: int price, int month, String name.
    A Budget osztály tárolja el egy attribútumban a konstruktorban megkapott items listát.
    Írj egy metódust, getItemsByMonth néven, mely egy hónapot vár (1-12) és visszaadja az Item-eket az adott hónapban!

    Bónusz feladat: ellenőrizzük a bemeneti paramétereket!
     */

    List<Item> items = new ArrayList<>();
    private Item item;

    public Budget(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItemsByMonth(int month) {
        List<Item> filteredItems = new ArrayList<>();
        for (Item i: items) {
            if (i.getMonth() == month) {
                filteredItems.add(i);
            }
        }
        return filteredItems;
    }

    public static void main(String[] args) {
        List<Item> items = Arrays.asList(new Item(500, 2, "pen"),
                new Item(600, 5, "pencil"),
                new Item(200, 2, "eraser"));
        Budget budget = new Budget(items);
        System.out.println(budget.getItemsByMonth(2).toString());

    }
}
