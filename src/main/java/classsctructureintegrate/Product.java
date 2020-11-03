package classsctructureintegrate;

public class Product {
    private String name;
    private int price;
    private int newPrice;
    private int decreasePerCent;
    private int increasePercent;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int decreasePrice(int decreasePerCent) {
        return int newPrice = (100 - decreasePerCent) / 100 * price;
    }

    public void increasePrice(int increasePercent) {
        return int newPrice = (100 + decreasePerCent) / 100 * price;
    }
}
