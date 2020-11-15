package attributes.bill;

public class BillMain {
    public static void main(String[] args) {
        Item item = new Item("laptop", 12, 325_000.0);
        Item item1 = new Item("hűtőpad",5, 5_000.0);
        System.out.println(item.getProduct());
        System.out.println(item1.getProduct());

        Bill bill = new Bill();
        bill.addItem(item);
        bill.addItem(item1);

        // System.out.println(bill.getItems());                 // Nem sikerül kiiratni..

        System.out.println(bill.calculateTotalPrice());



    }
}
