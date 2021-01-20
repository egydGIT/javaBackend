package exceptions.polynom;

public class Polynom {

    private double[] factors;

    private String[] factorsStringHungarianNotation;

    public Polynom(double[] factors) {
        if (factors == null) {
            throw new NullPointerException("NullPointerException means file is null.");
        }
        this.factors = factors;
    }

    public Polynom(String[] factorsStringHungarianNotation) {
        if (factorsStringHungarianNotation == null) {
            throw new NullPointerException("NullPointerException means file is null.");
        }
        try {
            // this.factorsStringHungarianNotation = factorsStringHungarianNotation;
            this.factors = convertStringFactorToDouble(factorsStringHungarianNotation);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException
                    ("If NumberFormatException is not enough, read one more exception: IllegalArgumentException", nfe);
        }
    }

    public double evaluate(double x) {                      // adott x értéknél visszaadja a polinomial értékét
        int n = factors.length - 1;                         // utólsó elem indexe = tömb hossza - 1
        double sum = 0;                                     // összegzés tétele
        for (int j = n; j >= 0; j--) {                      // végéről kezd iterálni
            sum += factors[j] * Math.pow(x,(double)n - j);  // Returns the value of the first argument raised to the power of the second argument.
        }                                                                //  ???
        return sum;
    }

    public double[] getFactors() {
        return factors;
    }

    public double[] convertStringFactorToDouble(String[] factorsStringHungarianNotation) {
        double[] factors = new double[factorsStringHungarianNotation.length];
        for(int i = 0; i < factorsStringHungarianNotation.length; i++) {
            factors[i] = Double.parseDouble(factorsStringHungarianNotation[i]);
        }
        return factors;
    }

    /*
    private double[] coefficients;

    public Polynom(double[] coefficients) {
        if (coefficients == null) {
            throw new NullPointerException("coefficients is null");
        }
        this.coefficients = coefficients;
    }

    public Polynom(String[] coefficientStrs) {
        if (coefficientStrs == null)
            throw new NullPointerException("coefficientStrs is null");
        try {
            this.coefficients = convertCoefficientStrs(coefficientStrs);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Illegal coefficients, not a number", ex);
        }
    }

    public double evaluate(double x) {
        int n = coefficients.length - 1;
        double sum = 0;
        for (int j = n; j >= 0; j--) {
            sum += coefficients[j] * Math.pow(x,(double)n - j);
        }
        return sum;
    }

    public double[] getCoefficients() {
        return coefficients;
    }

    private double[] convertCoefficientStrs(String[] coefficientStrs) {
        double[] coefficients = new double[coefficientStrs.length];
        for (int j = 0; j < coefficientStrs.length; j++) {
            coefficients[j] = Double.parseDouble(coefficientStrs[j]);
        }
        return coefficients;
    }

 */


}
