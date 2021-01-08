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

    @Override
    public int getNumberOfLegs() {
        return 2;
    }

    @Override
    public String getName() {
        return "Duck";
    }
}
