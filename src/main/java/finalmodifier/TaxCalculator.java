package finalmodifier;

public class TaxCalculator {
    public static final double TAX_PERCENT = 27;

    public double tax(double price) {
        return price * TAX_PERCENT / 100;
    }

    public double priceWithTax(double price) {
        return price + (price * TAX_PERCENT / 100);
    }

    public static void main(String[] args) {
        System.out.println("ÁFA tartalom: " + new TaxCalculator().tax(500) + " Ft");
        System.out.println("Az ár ÁFÁ-val: " + new TaxCalculator().priceWithTax(500) + " Ft");
    }
}
