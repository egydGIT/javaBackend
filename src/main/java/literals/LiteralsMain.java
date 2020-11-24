package literals;

public class LiteralsMain {
    int n = 1;
    int v = 2;

    Integer n2 = n;
    Integer v2 = v;

    double quotient1 = 3 / 4;                          // egész osztás eredménye 0, ezt konvertálja double-é  -> 0.0
    double quotient2 = 3.0 / 4;                        // egyik érték double-ként megadva                     -> 0.75
    double quotient3 = 3D / 4;                         // egyik érték után D betű                             -> 0.75

    long big = 3_244_444_444L;                         // szám után l vagy L

    String s = "árvíztűrőtükörfúrógép";

    String word = "tittle".toUpperCase();

    public static void main(String[] args) {
        LiteralsMain literalsMain = new LiteralsMain();

        // Összefűzés:
        System.out.println(literalsMain.n + "" + literalsMain.v);  // üres String miatt konkatenáció összeadás helyett
        System.out.println(1 + "" + 2);                    // csak literálok
        System.out.println("Szöveg után " + 1 + 2);        // Sting + int ebből konkatenáció
        System.out.println(1 + (2 + " Szöveg előtt"));     // kiértékelési sorrend balról jobbra, emiatt zárójel kell
        System.out.println(Integer.toString(1)
                            + Integer.toString(2));     // int burkoló osz-ja Integer, ennek toString met-a konvertál

        // Osztás:
        System.out.println(literalsMain.quotient1);
        System.out.println(literalsMain.quotient2);
        System.out.println(literalsMain.quotient3);

        // Nagy szám:
        System.out.println(literalsMain.big);

        // Karakterkódolás:
        System.out.println(literalsMain.s);

        // String, mint Objektum
        System.out.println(literalsMain.word);

        // Szám bináris String-ként:
        System.out.println(Integer.toString(1, 2));    // 1
        System.out.println(Integer.toString(-2, 2));   // -10

        System.out.println(Integer.toBinaryString(1));      // 1
        System.out.println(Integer.toBinaryString(-2));     // 11111111111111111111111111111110  // kettes komplemens


    }


}
