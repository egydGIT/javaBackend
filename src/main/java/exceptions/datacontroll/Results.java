package exceptions.datacontroll;

public enum Results {

    NO_ERROR(0),
    COMMENT(1),
    WORD_COUNT_ERROR(2),
    NUMBER_ERROR(3),                        // plusz érték
    VALUE_ERROR(4),
    DATE_ERROR(8),
    VALUE_AND_DATE_ERROR(12);

    private int code;

    Results(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}

/*
Hibakódok:

2: WORD_COUNT_ERROR, azaz a sor nem bontható 3 db , karakterrel elválaszható részre.
   + 3: NUMBER_ERROR sorszám nem értelmezhető
4: VALUE_ERROR, azaz a második rész nem double szám.
8: DATE_ERROR, azaz a harmadik rész nem yyyy.MM.dd. alakú dátum
12: VALUE_AND_DATE_ERROR: azaz egyszerre van VALUE_ERROR és DATE_ERROR is.
 */

