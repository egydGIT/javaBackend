package inheritancemethods.products;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PackedProduct extends Product {

    private int packingUnit;                    // termékből hány db helyezhető egy dobozba
    private BigDecimal weightOfBox;             // doboz súlya

    public PackedProduct(String name, BigDecimal unitWeight, int numberOfDecimals, int packingUnit, BigDecimal weightOfBox) {
        super(name, unitWeight, numberOfDecimals);
        this.packingUnit = packingUnit;
        this.weightOfBox = weightOfBox;
    }

    public PackedProduct(String name, BigDecimal unitWeigth, int packingUnit, BigDecimal weightOfBox) {
        super(name, unitWeigth);
        this.packingUnit = packingUnit;
        this.weightOfBox = weightOfBox;
    }

    public int getPackingUnit() {
        return packingUnit;
    }

    public BigDecimal getWeightOfBox() {
        return weightOfBox;
    }

    @Override
    public BigDecimal totalWeight(int pieces) {
        int numberOfBoxes = pieces % packingUnit == 0 ? pieces / packingUnit : pieces / packingUnit + 1;
        // szükséges dobozok száma = ha elfér(maradékos osztás 0), akkor db/dobozba férő db; ha nem, akkor +1 doboz
        BigDecimal box = weightOfBox.multiply(new BigDecimal(String.valueOf(numberOfBoxes)));
        // doboz súlya * dobozok száma = össz doboz súly
        return super.totalWeight(pieces).add(box).setScale(getNumberOfDecimals(), RoundingMode.HALF_UP);
        // össz termék súlya (ősben dekl met) + össz doboz súly
        // (.setScale(): tizedesjegyekkel variál, kerekít is, de ezt nem értem hogy)
    }

    public static void main(String[] args) {
        Product product = new Product("keksz", BigDecimal.valueOf(150.00));
        System.out.println(product.getUnitWeight());
        System.out.println(product.totalWeight(40));        // 6000.00

        PackedProduct packedProduct
                = new PackedProduct("keksz", BigDecimal.valueOf(150.00), 10, BigDecimal.valueOf(250.00));
        System.out.println(packedProduct.totalWeight(40));  // 7000.00   @override met-t hívja!



    }
}