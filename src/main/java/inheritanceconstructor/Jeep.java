package inheritanceconstructor;

public class Jeep extends Car{
    private double extraCapacity;
    private double extraFuel;

    public Jeep(double fuelRate, double fuel, double tankCapacity, double extraCapacity, double extraFuel) {
        super(fuelRate, fuel, tankCapacity);
        this.extraCapacity = extraCapacity;
        this.extraFuel = extraFuel;
    }

    @Override
    public void drive(int km) {
        // super.drive(km);
        if (!isEnoughFuelJeep(km)) {
            throw new RuntimeException("Not enough fuel available!");
        }
        double usedFuel = km * super.getFuelRate() / 100;
        extraFuel -= usedFuel;
        if (extraFuel < 0) {
            modifyFuelAmount(extraFuel);
            extraFuel = 0;
        }
    }

    @Override
    public double calculateRefillAmount() {
        // return super.calculateRefillAmount();
        return (super.getTankCapacity() + extraCapacity) - (super.getFuel() + extraFuel);
    }

    public boolean isEnoughFuelJeep(int distance) {
        return ((super.getFuel() + extraFuel) - distance * super.getFuelRate() / 100) >= 0.0;
    }

    public double getExtraFuel() {
        return extraFuel;
    }

    public double getExtraCapacity() {
        return extraCapacity;
    }
}
