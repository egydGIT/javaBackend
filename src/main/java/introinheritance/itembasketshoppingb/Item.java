package introinheritance.itembasketshoppingb;

public class Item {
    // private double taxAmount;
    private String barcode;
    private double nettoPrice;
    private int vatPerCent;

    public Item(String barcode, double nettoPrice, int vatPerCent) {
        this.barcode = barcode;
        this.nettoPrice = nettoPrice;
        this.vatPerCent = vatPerCent;
    }

    public double getTaxAmount() {
        return nettoPrice * (vatPerCent / 100.0);       // return nettoPrice * (1.0 * vatPercent / 100); ??
    }

    public String getBarcode() {
        return barcode;
    }

    public double getNettoPrice() {
        return nettoPrice;
    }

    @Override
    public String toString() {
        return "Item{" +
                "barcode='" + barcode + '\'' +
                ", nettoPrice=" + nettoPrice +
                ", vatPerCent=" + vatPerCent +
                '}';
    }
}
