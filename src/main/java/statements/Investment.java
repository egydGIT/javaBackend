package statements;

public class Investment {
    private double cost;                                   // Ezek jók
    private int fund;
    private int interestRate;
    private boolean active;

    public Investment( int fund, int interestRate) {        // Ez is jó. Generált.
        cost = 0.3;
        this.fund = fund;
        this.interestRate = interestRate;
        active = true;
    }

    public int getFund() {                                   // Jó, mert generált. :-)
        return fund;
    }

    public double getYield(int days) {
        return fund * interestRate * days / (100 * 365);     // A képletet puskáztam... De a metódusfej ok.
    }

    public double close(int days) {                          // A képletet puskáztam. De a metódusfej és az active lezárás ok.
        double totalAmount = (getFund() + getYield(days)) * ( 1-cost / 100 );
        double payout = active ? totalAmount : 0;
        active = false;
        return payout;
    }


}


//    { }