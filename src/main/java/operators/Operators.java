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
}
