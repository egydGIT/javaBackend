package defaultconstructor;

public class SimpleDate {
    private int year;
    private int month;
    private int day;

    public void setDate(int year, int month, int day) {
        if (!isCorrect(year, month, day)) {
            // throw new IllegalArgumentException("Please check the date parameters: " + year + "." + month + "." + day);
            throw new IllegalArgumentException("One or more given parameter cannot be applied! " + year + ", " + month + ", " + day);
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    private boolean isCorrect(int year, int month, int day) {
        if (year < 1900) {
            return  false;
        }
        if (month > 12 || month < 1) {
            return false;
        }
        int monthLength = calculateMonthLength(year, month);
        if (day < 1 || day > monthLength) {
            return false;
        }
        return true;
    }

    private boolean isLeapYear(int year) {                              // cp.
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    private int calculateMonthLength(int year, int month) {
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12:
                return 31;
            case 4, 6, 9, 11:
                return  30;
            default:
                if (isLeapYear(year)) {
                    return 29;
                } else {
                    return 28;
                }
        }
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        // return year + "." + month + "." + day + ".";
        return year + ", " + month + ", " + day;
    }

    public static void main(String[] args) {
        // SimpleDate simpleDate1 = new SimpleDate().setDate(2020, 12, 8);  // default konstruktor
        SimpleDate simpleDate2 = new SimpleDate();
        simpleDate2.setDate(2020, 12, 8);
        System.out.println(simpleDate2);
/*
        SimpleDate simpleDate3 = new SimpleDate();  // IllegalArgumentException: One or more given parameter cannot be applied! 2020, 11, 31
        simpleDate3.setDate(2020, 11, 31);
        System.out.println(simpleDate3);

        SimpleDate simpleDate4 = new SimpleDate();
        simpleDate4.setDate(2020, 15, 8);
        System.out.println(simpleDate4);

        SimpleDate simpleDate5 = new SimpleDate();
        simpleDate5.setDate(220, 12, 8);
        System.out.println(simpleDate5);
*/
        SimpleDate simpleDate6 = new SimpleDate();
        simpleDate6.setDate(2020, 2, 29);
        System.out.println(simpleDate6);
    }
}
