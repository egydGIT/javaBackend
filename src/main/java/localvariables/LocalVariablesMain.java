package localvariables;

public class LocalVariablesMain {
    public static void main(String[] args) {
        boolean b;
        // System.out.println(b);    // Nem. Ahhoz, hogy használni tudjunk egy lokális változót, értéket kell neki adni. Nincs alapértelmezett értékük.
        b = false;

        int i = 2;
        // i j egy sorban nem lehet definiálni. - ?
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
