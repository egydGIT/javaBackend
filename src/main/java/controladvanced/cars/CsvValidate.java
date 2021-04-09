package controladvanced.cars;

import java.util.ArrayList;
import java.util.List;

public class CsvValidate {

    // "ABC-123;2007;Volvo;red"

/*
    public List<String> filterLines1(List<String> lines) {
        List<String> validLines = new ArrayList<>();
        for (String line : lines) {
            String[] parts = line.split(";");
            if (parts.length != 4) {

                // sérült, ki kell pótolni

            }
            validLines.add(line);
        }
        return validLines;
    }

 */


    public List<String> filterLines2(List<String> lines) {          // Solution
        List<String> validLines = new ArrayList<>();                // lista, amibe az eredményt mentjük
        for (String line : lines) {                                 // for each, paraméterben átadott listán megy végig
            String[] parts = line.split(";");                 // ; elválasztó karakternél vágja a Stringet
                                                                        // tömböt ad vissza, elemek vesszővel elválasztva
            if (parts.length != 4) {                                // ha a tömb hossza nem 4
                continue;
            }
            if (parts[0].length() != 7 || !parts[0].contains("-")) {        // tömb első elemének hossza nem 7
                                                                            // tömb első eleme nem tartalmaz -
                continue;
            }
            int year = Integer.parseInt(parts[1]);                  // tömb 2. elemét (év)számmá konvertálja
            if (year < 1970 || year > 2019) {                       // ha későbbi, mint 1970, és korábbi, mint 2019
                continue;
            }
            validLines.add(line);                                   // akkor a listához adja hozzá a feldarabolás előtti
        }                                                                       // Stringet, mert valid
        return validLines;
    }

}
