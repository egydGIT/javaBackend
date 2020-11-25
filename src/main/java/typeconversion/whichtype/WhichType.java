package typeconversion.whichtype;

import java.util.ArrayList;
import java.util.List;

public class WhichType {
    /*
    public String whichType (String s) {
        // int i = Integer.parseInt(s);
        if (s.length() <= 8) {
            System.out.println("Konvertálható: byte-ba");
            return s;
        }
        if (s.length() <= 16 && s.length() >= 8) {
            System.out.println("Konvertálható: short-ba");
            return s;
        }
        if (s.length() <= 32 && s.length() >= 16) {
            System.out.println("Konvertálható: int-be");
            return s;
        }
        if (s.length() <= 64 && s.length() >= 32) {
            System.out.println("Csak: long-ban tárolható.");
            return s;
        }
        return s;
    }


    public static void main(String[] args) {
        new WhichType().whichType("100101");
        new WhichType().whichType("1001000100100101");
        new WhichType().whichType("1001000110010011001000100101");
        new WhichType().whichType("1001000110010011001001000100100100100000000001000100101");

    }

     */

    public List<Type> whichType(String s) {
        List<Type> types = new ArrayList<>();
        for (Type type: Type.values()) {            // Type tipusó type változó végigiterál a Type enum értékein
            Long value = Long.parseLong(s);         // s Stringet Long-gá konvertálja, value vált-hoz rendeli
            if (value > type.getMinValue() && value < type.getMaxValue()) {
                                        // type változó éppen aktuális min értéke get met-sal lekérve, (vissz.ért: Long)
                                            // kisebb, mint a String s Long-gá konvertálva
                                        // ÉS type változó éppen aktuális max értéke get met-sal lekérve, (vissz.ért: Long)
                                            // nagyobb, mint a String s Long-gá konvertálva
                types.add(type);        // a type nevű listához, adja hozzá a type vált aktuális értékét
            }
        }
        return types;                   // térjen vissza a listával
    }
}
