package classstructureintegrate;

public class Product {
    private String name;
    private int price;
    private int perCent;

    public Product(String name, int price, int perCent) {
        this.name = name;
        this.price = price;
        this.perCent = perCent;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getPerCent() {
        return perCent;
    }

    public void decreasePrice() {
        price = (100 - perCent) / 100 * price;
    }

    public void increasePrice(int price, int perCent) {
        price = (100 + perCent) / 100 * price;
    }
}
