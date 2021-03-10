/*
CDV
Írj egy CdvCheck.check() metódust (paraméterezése, visszatérési értéke kiderül a tesztesetből), mely kap egy adószámot,
és eldönti róla, hogy helyes-e! A következőképp kell eldönteni. Fogni kell az első kilenc számjegyet,
és megszorozni rendre 1, 2, ..., 9 számmal. Az eredményt kell összegezni, majd maradékos osztani 11-el.
A 10. számjegynek meg kell egyeznie ezzel a számmal (maradékkal).

Pl.:

8365670003
1 * 8 + 2 * 3 + 3 * 6 + ... + 9 * 0 = 124
124 maradékos osztás 11-el = 3
3 (maradék) == 3 (10. számhegy) - az adószám megfelelő
Ha a paraméterként átadott adószám nem 10 számjegy, vagy nem csak számjegy szerepel benne, IllegalArgumentException kivételt kell dobni.
 */

package exam03retake01;

import java.util.Arrays;
import java.util.List;

public class CdvCheck {

    private static final int LENGTH = 10;

    public boolean check(String s) {
        if (s.length() != LENGTH) {
            throw new IllegalArgumentException("Length is not correct.");
        }
        int sum = 0;
        for (int i = 0; i < LENGTH-1; i++) {
//            int digit = Integer.parseInt(s.substring(i, i + 1));

//            try {
//                int digit = Integer.parseInt(Character.toString(s.charAt(i)));
//            } catch (NumberFormatException ne) {
//                throw new IllegalArgumentException("Not number.");
//            }

            if (!(s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                throw new IllegalArgumentException("Not number.");
            }
            int digit = s.charAt(i) - '0';
            sum += digit * (i + 1);
        }
        int lastDigit = s.charAt(LENGTH -1) - '0';

        return sum % 11 == lastDigit;
    }

    public boolean checkMy(String s) {
        if (s.length() != 10 && notNumber(s)) {
            throw new IllegalArgumentException("Length is not correct.");
        }
        int sum = 0;
        String[] array = s.split("");
        //System.out.println(Arrays.toString(array));
        for (int i = 0; i < 9; i++) {
            int number = Integer.parseInt(array[i]);
            //System.out.println(number);
            //System.out.println(number * (i + 1));
            sum += number * (i + 1);
        }
        //System.out.println(sum);

        int lastNumber = Integer.parseInt(array[array.length-1]);
        //System.out.println(lastNumber);

        int result = sum % 11;
        if (result == lastNumber) {
            return true;
        }
        return false;
    }

    private boolean notNumber(String s) {
        try {
            Long.parseLong(s);
            return true;
        }
        catch (NumberFormatException ne) {
            return false;
        }
    }


    public static void main(String[] args) {
        CdvCheck cdvCheck = new CdvCheck();

        System.out.println(cdvCheck.checkMy("1234567890"));
        System.out.println(cdvCheck.check("1234567890"));
    }
}
