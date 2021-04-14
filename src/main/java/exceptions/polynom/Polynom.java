package exceptions.polynom;

public class Polynom {

    private double[] factors;

    private String[] factorsString;

    public Polynom(double[] factors) {
        if (factors == null) {
//            throw new NullPointerException("NullPointerException means file is null.");
            throw new NullPointerException("coefficients is null");
        }
        this.factors = factors;
    }

    public Polynom(String[] factorsString) {
        if (factorsString == null) {
//            throw new NullPointerException("NullPointerException means file is null.");
            throw new NullPointerException("coefficientStrs is null");
        }
        try {
            // this.factorsStringHungarianNotation = factorsStringHungarianNotation;
            this.factors = convertStringFactorToDouble(factorsString);
        } catch (NumberFormatException nfe) {
//            throw new IllegalArgumentException
//                    ("If NumberFormatException is not enough, read one more exception: IllegalArgumentException", nfe);
            throw new IllegalArgumentException("Illegal coefficients, not a number", nfe);
        }
    }

    public double evaluate(double x) {                      // adott x értéknél visszaadja a polinomial értékét
        int n = factors.length - 1;                         // utólsó elem indexe = tömb hossza - 1
        double sum = 0;                                     // összegzés tétele
        for (int j = n; j >= 0; j--) {                      // végéről kezd iterálni
            sum += factors[j] * Math.pow(x,(double)n - j);  // Returns the value of the first argument raised to the power of the second argument.
        }
        return sum;
    }

    public double[] convertStringFactorToDouble(String[] factorsString) {    // String tömb elemeit számmá alakító met.
        double[] factors = new double[factorsString.length];                 // új tömb a létrejövő double értékeknek,
                                                                             // hossza = a String tömb hosszával
        for(int i = 0; i < factorsString.length; i++) {                      // for ciklus
            factors[i] = Double.parseDouble(factorsString[i]);               // par-ként átadott Sting tömb i. elemét Double számmá konvertálja
        }                                                                    // double tömb i. elemének értékül adja -> unboxing
        return factors;                                                      // double tömbbel tér vissza
    }

    public double[] getFactors() {
        return factors;
    }

    public String[] getFactorsString() {
        return factorsString;
    }


}




