package attributes.bill;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BillMain {
    public static void main(String[] args) {
        Item item = new Item("laptop", 1, 325_000.0);
        Item item1 = new Item("hűtőpad",2, 5_000.0);

        System.out.println("Számla");
        System.out.println(item.getProduct() + " " + item.getPrice());
        System.out.println(item1.getProduct() + " " + item1.getPrice());

        Bill bill = new Bill();
        bill.addItem(item);
        bill.addItem(item1);

        System.out.println(bill.getItems());

        System.out.println("Fizetendő: " + bill.calculateTotalPrice());

        System.out.println(bill.getItemNames());


    }
}
