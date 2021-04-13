package interfaces.animal;

public class Duck implements Animal {
/*
    private int numberOfLegs;
    private String name;

    public Duck(int numberOfLegs, String name) {
        this.numberOfLegs = numberOfLegs;
        this.name = name;
    }

 */

    public static final int NUMBER_OF_LEGS = 2;

    @Override
    public int getNumberOfLegs() {
        return NUMBER_OF_LEGS;
    }

    @Override
    public String getName() {
        return "Duck";
    }
}
