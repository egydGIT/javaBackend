package statements;

public class StatementMain {
    public static void main(String[] args) {
        int x = 5 + 6;
        int y = 11 - x;
        int z = 8;

        boolean b = y < x;                              // Javítás
        System.out.println(b);

        System.out.println( b = (y < x) ? true : false);  // Ez végül is működik, de megbonyolítottam.
        System.out.println(b);

        boolean c = b || (5 < z);                         // Javítás
        System.out.println(c);

        System.out.println( c = (b == true) || (5 < z) ? true : false);   // Ez is működik, de ezt is megbonyolítottam.
        System.out.println(c);

        z ++;
        System.out.println(z);
    }
}
