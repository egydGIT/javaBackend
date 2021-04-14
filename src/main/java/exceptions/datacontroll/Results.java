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


