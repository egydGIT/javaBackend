package controliteration.pi;

public class Pi {

    /*
    Szász Pál matematikus pi-verse* 1952-ből:

    "Nem a régi s durva közelítés,
    Mi szótól szóig így kijön
    Betűiket számlálva.
    Ludolph eredménye már,
    Ha itt végezzük húsz jegyen.
    De rendre kijő még tíz pontosan,
    Azt is bízvást ígérhetem."

    (forrás)

    *pi-vers: a vers szavainak hossza megegyezik a pi számjegyeinek értékeivel.
     */

    private static final String POEM = "Nem a régi s durva közelítés,\n" +
            "    Mi szótól szóig így kijön\n" +
            "    Betűiket számlálva.\n" +
            "    Ludolph eredménye már,\n" +
            "    Ha itt végezzük húsz jegyen.\n" +
            "    De rendre kijő még tíz pontosan,\n" +
            "    Azt is bízvást ígérhetem.";

    public static final String POINT = ".";
/*
    public String poemToPi() {
        String s = "";
        int counter = 0;
        for (int i = 0; i < POEM.length(); i++) {
            if (counter != 0 && !Character.isAlphabetic(POEM.charAt(i))) {
                s += counter;
            }
            counter++;
        }
        return s;
    }

 */



    public String getPi() {
        String s = "";
        int counter = 0;
        for (int i = 0; i < POEM.length(); i++) {
            if (counter != 0 && !Character.isAlphabetic(POEM.charAt(i))) {
                s += counter;
                if (s.length() == 1) {
                    s += POINT;
                }
                counter = 0;
            }
            if (Character.isAlphabetic(POEM.charAt(i))) {
                counter ++;
            }
        }
        return s;
    }



    public static void main(String[] args) {
        // System.out.println(new Pi().poemToPi());
        System.out.println(new Pi().getPi());                          // 3.141592653589793238462643383279
    }

}
