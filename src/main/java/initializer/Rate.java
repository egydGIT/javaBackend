package initializer;

public class Rate {
    private double conversionFactor;
    private Currency currency;

    public Rate(Currency currency, double conversionFactor) {
        this.conversionFactor = conversionFactor;
        this.currency = currency;
    }

    public Currency getCurrency() {
        return currency;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }
}
