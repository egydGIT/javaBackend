package exam03;

public class Boat {

    private final int basicPrice = 100_000;

    private String name;
    private int maxPassengers;

    public Boat(String name, int maxPassengers) {
        this.name = name;
        this.maxPassengers = maxPassengers;
    }

    public String getName() {
        return name;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public int getBasicPrice() {
        return basicPrice;
    }
}
