package classstructureintegrate;

public class Product {
    private String name;
    private int price;
    private int perCent;

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

    public int getPerCent() {
        return perCent;
    }

    public int decreasePrice(int perCent) {
        return price = (100 - perCent) * price / 100;
    }

    public int increasePrice(int perCent) {
        return price = (100 + perCent) * price / 100;
    }
}
