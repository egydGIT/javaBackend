package week06d05;

public class Biscuit {

     /*
    Junior
    Készíts egy Biscuit nevű osztályt, amelynek van két attribútuma: BiscuitType type és int gramAmount.
    A BiscuitType legyen felsorolásos típus a három kedvenc kekszfajtáddal!
    A Biscuit nevű osztálynak legyen egy static metódusa of néven, mely paraméterként egy BiscuitType-ot,
    és egy int gramAmount-ot vár és visszaad egy új Biscuit objektumot amelyet a megadott paraméterek alapján hoz létre.

    Bónusz feladat: konzolra írás esetén a Biscuit jelenítse meg a type és a gramAmount mezőket!
     */

    private BiscuitType type;
    private int gramAmount;

    public Biscuit() {
    }

    public Biscuit(BiscuitType type, int gramAmount) {
        if (type == null) {
            throw new IllegalArgumentException("Please give valid type!");
        }
        if (gramAmount == 0) {
            throw new IllegalArgumentException("Please give valid amount!");
        }
        this.type = type;
        this.gramAmount = gramAmount;
    }

    public static Biscuit of(BiscuitType biscuitType, int gramAmount) {
        return new Biscuit(biscuitType, gramAmount);
    }

    public BiscuitType getType() {
        return type;
    }

    public int getGramAmount() {
        return gramAmount;
    }

    @Override
    public String toString() {
        return "Biscuit{" +
                "type=" + type +
                ", gramAmount=" + gramAmount +
                '}';
    }

    public static void main(String[] args) {
        // Konstruktor-ral:
        Biscuit biscuit = new Biscuit(BiscuitType.HIT, 150);    // Heap
        System.out.println(biscuit);

        // Static met-al:
        System.out.println(Biscuit.of(BiscuitType.HIT, 150));   // Metaspace
    }
}
