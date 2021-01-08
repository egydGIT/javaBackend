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

    @Override
    public int getNumberOfLegs() {
        return 0;
    }

    @Override
    public String getName() {
        return "Warm";
    }
}
