package statements;

public class StatementMain {
    public static void main(String[] args) {
        int x = 5 + 6;
        int y = 11 - x;
        int z = 8;

        boolean b;
        System.out.println( b = (y < x) ? true : false);
        System.out.println(b);

        boolean c;
        System.out.println( c = (b == true) || (5 < z) ? true : false);
        System.out.println(c);

        z ++;
        System.out.println(z);
    }
}
