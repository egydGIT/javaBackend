package operators;

public class OperatorsMain {
    public static void main(String[] args) {
        Operators operators = new Operators();

        System.out.println(operators.isEven(4));
        System.out.println(operators.isEven(5));
        System.out.println(operators.isEven(6));
        System.out.println(operators.isEven(637));

        // 16
        System.out.println(Integer.toBinaryString(16));             // decimális -> bináris   // 10000
        System.out.println(Integer.parseInt("10000", 2));     // bináris -> decimális    // 16

        System.out.println(Integer.toBinaryString(16 >> 1));     // jobbra léptetés: balról belép 0, de nem írja ki
                                                                        //  1000
        System.out.println(Integer.parseInt("1000", 2));        //  8 -> 2-vel osztás

        System.out.println(Integer.toBinaryString(16 << 1));     // balra léptetés: jobbról belép 0
                                                                        // 100000
        System.out.println(Integer.parseInt("100000", 2));      // 32 -> 2-vel szorzás


        // 13
        System.out.println(Integer.toBinaryString(13));             // 1101
        System.out.println(Integer.toBinaryString(13 >> 1));        // 110
        System.out.println(Integer.parseInt("110", 2));           // 6  -> egész osztás 2-vel
        System.out.println(Integer.toBinaryString(13 << 1));        // 11010
        System.out.println(Integer.parseInt("11010", 2));         // 26 -> szorzás 2-vel

        System.out.println(Integer.toBinaryString(13 << 2));        // 110100
        System.out.println(Integer.parseInt("110100", 2));      // 52 -> szorzás 2 a másodikonnal

        System.out.println(Integer.toBinaryString(13 << 3));        // 1101000
        System.out.println(Integer.parseInt("1101000", 2));     // 104 -> szorzás 2 a harmadikonnal


        System.out.println(Integer.parseInt(operators.multiplyByPowerOfTwo(6, 3), 2));

    }
}
