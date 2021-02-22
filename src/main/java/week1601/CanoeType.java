package week1601;

public enum CanoeType {

    RED(1.0),
    GREEN(1.2),
    BLUE(1.5);

    private double multiplier;

    CanoeType(double multiplier) {
        this.multiplier = multiplier;
    }

    public double getMultiplier() {
        return multiplier;
    }

}