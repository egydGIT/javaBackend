package interfacestaticmethods;

public class SomethingWithValue implements Valued {

    private String name;

    private int value;

    public SomethingWithValue(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }
}
