package enumtype.unit;

public enum LengthUnit {
/*
    MILLIMETER(true, LengthUnit.MILLIMETER.convertToMm),
    CENTIMETER(true, LengthUnit.CENTIMETER.convertToMm * 10),
    METER(true, LengthUnit.METER.convertToMm * 100),
    YARD(false, LengthUnit.YARD.convertToMm * 914.4),
    FOOT(false, LengthUnit.FOOT.convertToMm * 304.8),
    INCH(false, LengthUnit.INCH.convertToMm * 25.4);

 */

    MILLIMETER(true, 1000),
    CENTIMETER(true, 100),
    METER(true, 1),
    YARD(false, 9144),
    FOOT(false, 3048),
    INCH(false, 254);

    private final boolean SI;

    // private final double convertToMm;

    private final int inMillimeter;

    LengthUnit(boolean SI, int inMillimeter) {
        this.SI = SI;
        this.inMillimeter = inMillimeter;
    }

    public boolean isSI() {
        return SI;
    }

    /*
    public double getConvertToMm() {
        return convertToMm;
    }

     */

    public int getInMillimeter() {
        return inMillimeter;
    }
}


