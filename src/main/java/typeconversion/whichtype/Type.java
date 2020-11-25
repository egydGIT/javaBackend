package typeconversion.whichtype;

public enum Type {
    BYTE(Byte.MIN_VALUE, Byte.MAX_VALUE),           // Enum típusok paraméterezve
    SHORT(Short.MIN_VALUE, Short.MAX_VALUE),                // csomagoló oszt-ok konstansokat tartalmaznak
    INT(Integer.MIN_VALUE, Integer.MAX_VALUE),              // a szélsőséges eredményekre
    LONG(Long.MIN_VALUE, Long.MAX_VALUE);                   // értelmezési tartományuk legkisebb/legn-bb értékét tárolják

    private final long minValue;                    // konstans attributum deklaráció (enumok paraméterezéshez)

    private final long maxValue;

    Type(long minValue, long maxValue) {            // Konstruktor: konstansok inicializálásához
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public Long getMinValue() {                     // Getterek: attr értékeit ezen keresztül lehet lekérni
        return minValue;
    }

    public Long getMaxValue() {
        return maxValue;
    }

}
