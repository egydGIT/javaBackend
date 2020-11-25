package operators;

public class Operators {
    public boolean isEven(int n) {
        if (n % 2 == 0) {
            System.out.println("Even number.");
            return true;
        } else {
            System.out.println("Odd number.");
            return false;
        }
    }

/*
    public String multiplyByPowerOfTwo(int number, int numberOfMultiplyWithTwo) {
        String result = Integer.toBinaryString(number << numberOfMultiplyWithTwo);
        return result;
    }

 */

    public int multiplyByPowerOfTwo(int number, int numberOfMultiplyWithTwo) {
        String result = Integer.toBinaryString(number << numberOfMultiplyWithTwo);
        int result2 = Integer.parseInt(result, 2);
        return result2;
    }


}
