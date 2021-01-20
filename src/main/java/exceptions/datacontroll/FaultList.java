package exceptions.datacontroll;

import java.text.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class FaultList {
    // Az adatsorok szerkezete: sorszám, mért érték, mérésdátum.
    // Pl. 12, 34.5, 2014.05.22.

    // A megjegyzésbe tett sorok ugyanúgy , karakterrel elválasztott három részből állnak, csak az első rész nem alakítható számmá.
    // Pl. M12, 12, 2014.01.01.

    // A jelentés egy List<String> legyen, ahol a String tartalmazza a hibás sor sorszámát és a hiba kódját, sorszam, hibakód alakban.

    public String[] splitLines(String line) {
        String[] words = line.split(", ");
        return words;
    }

    public Results checkData(String[] words) {

        if (words.length != 3) {
            System.out.println("Code: " + Results.WORD_COUNT_ERROR.getCode() + ", Line no: " + Integer.parseInt(words[0]));
            return Results.WORD_COUNT_ERROR;
        }

        try {
            int lineNumber = Integer.parseInt(words[0]);
        } catch (NumberFormatException nfe) {
            System.out.println("Code: " + Results.NUMBER_ERROR.getCode() + ", Line no: " + words[0]);
            return Results.NUMBER_ERROR;
        }

        try {
            double measuredValue = Double.parseDouble(words[1]);
        } catch (NumberFormatException e) {
            System.out.println("Code: " + Results.VALUE_ERROR.getCode() + ", Line no: " + Integer.parseInt(words[0]));
            return Results.VALUE_ERROR;
        }

        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
            dateFormat.parse(words[2]);
        } catch (ParseException e) {
            System.out.println("Code: " + Results.DATE_ERROR.getCode() + ", Line no: " + Integer.parseInt(words[0]));
            return Results.DATE_ERROR;
        }

        return Results.NO_ERROR;
    }

    public static void main(String[] args) {
        FaultList faultList = new FaultList();
        System.out.println(Arrays.toString(faultList.splitLines("01, 34.5, 2021.01.20.")));
        System.out.println(faultList.checkData(faultList.splitLines("01, 34.5, 2021.01.20.")));
//        [01, 34.5, 2021.01.20.]
//        NO_ERROR

        System.out.println("");
        System.out.println(Arrays.toString(faultList.splitLines("02, 34.5")));
        System.out.println(faultList.checkData(faultList.splitLines("02, 34.5")));
//        [02, 34.5]
//        Code: 2, Line no: 2
//        WORD_COUNT_ERROR

        System.out.println("");
        System.out.println(Arrays.toString(faultList.splitLines("cc, 34.5, 2021.01.20.")));
        System.out.println(faultList.checkData(faultList.splitLines("cc, 34.5, 2021.01.20.")));
//        [cc, 34.5, 2021.01.20.]
//        Code: 3, Line no: cc
//        NUMBER_ERROR

        System.out.println("");
        System.out.println(Arrays.toString(faultList.splitLines("04, 3ff, 2021.01.20.")));
        System.out.println(faultList.checkData(faultList.splitLines("04, 3ff, 2021.01.20.")));
//        [04, 3ff, 2021.01.20.]
//        Code: 4, Line no: 4
//        VALUE_ERROR

        System.out.println("");
        System.out.println(Arrays.toString(faultList.splitLines("05, 34.5, 2021-99-20")));
        System.out.println(faultList.checkData(faultList.splitLines("05, 34.5, 2021-99-20")));
//        [05, 34.5, 2021-99-20]
//        Code: 8, Line no: 5
//        DATE_ERROR

    }

    /*

    public static final int SPECIAL_VALUE_COMMENT_LINE = -1;

    private Results result;

    public List<String> processLines(List<String> lines) {
        if (lines == null) {
            throw new IllegalArgumentException("lines is null");
        }

        List<String> faults = new ArrayList<>();
        for (String line: lines) {
            String[] words = line.split(",");
            int lineNumber = readLineNumber(words[0]);
            if (lineNumber != SPECIAL_VALUE_COMMENT_LINE) {
                Results result = processLine(words);
                if (result != Results.NO_ERROR) {
                    faults.add(faultLine(lineNumber, result.getCode()));
                }
            }
        }
        return faults;
    }

    private int readLineNumber(String word) {
        try {
            return Integer.parseInt(word);
        } catch (NumberFormatException ex) {
            return SPECIAL_VALUE_COMMENT_LINE;
        }
    }

    private Results processLine(String[] words) {
        if (words.length != 3) {
            return Results.WORD_COUNT_ERROR;
        }

        boolean valueIsValid =  isValueValid(words[1]);
        boolean dateIsValid = isDateValid(words[2]);

        if (!valueIsValid && !dateIsValid) {
            return Results.VALUE_AND_DATE_ERROR;
        }
        else if (!dateIsValid) {
            return Results.DATE_ERROR;
        }
        else if (!valueIsValid) {
            return Results.VALUE_ERROR;
        }

        return Results.NO_ERROR;
    }

    private boolean isValueValid(String word) {
        try {
            Double.parseDouble(word);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private boolean isDateValid(String word) {
        try {
            DateFormat df = new SimpleDateFormat("yyyy.MM.dd.");
            df.parse(word);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }

    private String faultLine(int lineNumber, int resultCode) {
        return lineNumber + "," + resultCode;
    }

     */



}
