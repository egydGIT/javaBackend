package localvariables;

public class LocalVariablesMain {
    public static void main(String[] args) {
        boolean b;
        // System.out.println(b);    // Nem. Ahhoz, hogy használni tudjunk egy lokális változót, értéket kell neki adni. Nincs alapértelmezett értékük.
        b = false;

        int a = 2;
        int i = 3, j = 4;            // i j egy sorban lehet két értéket definiálni !!
        // System.out.println(j);

        int k = i;

        // String s;
        // System.out.println(s);      // Nincs default inicializálás.

        String s = "Hello World";
        System.out.println(s);

        String t = s;

        {
            int x = 0;
        }
        // System.out.println(x);    // Nem, Lokális változó élettartama/láthatósága a blokk végéig.

        String out = "Kívül";
        {
            System.out.println(out);    // Igen. Globalscope.
        }


    }



}
