package introcontrol;

public class IntroControl {

    public int substractTenIfGreaterThanTen(int number) {
        if ( number <= 10 ) {
            return number;
        } else {
            return number - 10;
        }
    }

    public String describeNumber(int number) {
        if ( number != 0 ){
            return "not zero";
        } else {
            return "zero";
        }
    }

    public String greetingToJoe(String name) {
        if (name.equals("Joe")) {
            return "Hello Joe";
        } else {
            return "";
        }
    }

    public double calculateBonus(int sale) {
        if ( sale >= 1_000_000 ) {
            return sale * 0.1;
        } else {
            return 0;
        }
    }

    public int calculateConsumption(int prev, int next) {           // Értem :-) !
        if (prev <= next) {
            return next - prev;
        } else {
            return 10_000 - prev + next;
        }
    }

    public void printNumbers(int max) {
        for ( int i = 0; i <= max; i++ ) {
            System.out.print(i + ", ");
        }
    }


    public void printNumbersBeetwen(int min, int max) {
        for ( int i = min; i <= max; i++ ) {
            System.out.print(i + ", ");
        }
    }


    public void printNumbersBeetwenAnyDirection(int a, int b) {
        if ( a < b ) {
            for ( int i = a; i <= b ; i++ ) {
                System.out.print(i + ", ");
            }
        } else {
            for ( int i = a; i >= b ; i-- ) {
                System.out.print(i + ", ");
            }
        }
    }


    public void printOddNumber(int max) {
        for ( int i = 1; i <= max; i = i +2 ) {
            System.out.print(i + ", ");
        }
    }

}
