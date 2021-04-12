package inheritanceattributes;

public class ShippedBook extends Book{

    private int shippingCost;

    public ShippedBook(String title, int price, int shippingCost) {
        super(title, price);                // szülő oszt konstruktorát hívja a gyermek oszt konstruktora = explicit super()
        this.shippingCost = shippingCost;
    }

    public int order(int pieces) {
        return pieces * price + shippingCost;
    }

    public String toString() {
        //return getTitle() + " / " + price + " + " + shippingCost;
        return getTitle() + ":" + price + " - " + shippingCost;
    }

    public static void main(String[] args) {
        ShippedBook shippedBook = new ShippedBook("Barry Burd: Java", 4300, 20000);
        System.out.println(shippedBook.toString());
        System.out.println(shippedBook.price);                      // protected attr. szülő oszt-ból
        System.out.println(shippedBook.purchase(24));
        System.out.println(shippedBook.order(24));

    }
}
