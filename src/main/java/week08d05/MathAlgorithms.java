package week08d05;

public class MathAlgorithms {

    /*
    Junior
    A week08d05 csomagban készíts egy osztályt MathAlgorithms néven. Legyen benne egy metódus, greatestCommonDivisor(),
    ami paraméterül vár két pozitív egész számot és visszaadja a legnagyobb közös osztójukat.
     */

    public int greatestCommonDivisor(int a, int b) {
        int result = 1;
        for (int i = 2; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0) {
                result = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MathAlgorithms mathAlgorithms = new MathAlgorithms();
        System.out.println(mathAlgorithms.greatestCommonDivisor(18, 9));
        System.out.println(mathAlgorithms.greatestCommonDivisor(24, 16));
    }
}
