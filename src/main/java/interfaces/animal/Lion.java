package interfaces.animal;

public class Lion implements Animal{
/*
    private int numberOfLegs;
    private String name;

    public Lion(int numberOfLegs, String name) {
        this.numberOfLegs = numberOfLegs;
        this.name = name;
    }

 */

    @Override
    public int getNumberOfLegs() {
        return 4;
    }

    @Override
    public String getName() {
        return "Lion";
    }
}
