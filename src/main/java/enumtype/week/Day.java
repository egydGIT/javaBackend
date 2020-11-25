package enumtype.week;

public enum Day {
    MONDAY(DayType.WORKDAY),
    TUESDAY(DayType.WORKDAY),
    WEDNESDAY(DayType.WORKDAY),
    THURSDAY(DayType.WORKDAY),
    FRIDAY(DayType.WORKDAY),
    SATURDAY(DayType.HOLIDAY),
    SUNDAY(DayType.HOLIDAY);                 // Enum

    private final DayType dayType;           // attributum deklaráció, konstans(final), konstruktorral kap értéket

    Day(DayType dayType){                    // Konstruktor
        this.dayType = dayType;
    }

    public DayType getDayType() {            // Getter, attributum értékéhez csak ezzel lehet hozzáférni
        return dayType;
    }
}
