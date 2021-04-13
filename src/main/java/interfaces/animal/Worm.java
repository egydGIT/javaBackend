package interfaces.animal;

public class Worm implements Animal {
/*
    private int numberOfLegs;
    private String name;

    public Worm(int numberOfLegs, String name) {
        this.numberOfLegs = numberOfLegs;
        this.name = name;
    }

 */

    public static final int NUMBER_OF_LEGS = 0;

    @Override
    public int getNumberOfLegs() {
        return NUMBER_OF_LEGS;
    }

    @Override
    public String getName() {
        return "Warm";
    }
}
