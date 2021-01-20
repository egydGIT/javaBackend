package exceptionclass;

public class SimpleTime {

    private int hour;

    private int min;

    private String timeWitString;

    public SimpleTime(int hour, int min) {
        if (hour < 0 || hour > 23) {
            throw new InvalidTimeException("Hour is invalid (0-23)");
        }
        if (min < 0 || min > 59) {
            throw new InvalidTimeException("Minute is invalid (0-59)");
        }
        this.hour = hour;
        this.min = min;
    }

    public SimpleTime(String timeWitString) {
        if (timeWitString == null || timeWitString.isBlank() || timeWitString.isEmpty()) {
            throw new InvalidTimeException("Time is null");
        }
        if (!":".equals(timeWitString.substring(2)) && timeWitString.length() != "hh:mm".length()) {
            throw new InvalidTimeException("Time is not hh:mm");
        }
        int hour;
        try {
            hour = Integer.parseInt(timeWitString.substring(0, 2));
        } catch (NumberFormatException nfe){
            throw new InvalidTimeException("Time is invalid");
        }
        int min;
        try {
            min = Integer.parseInt(timeWitString.substring(3));
        } catch (NumberFormatException nfe){
            throw new InvalidTimeException("Time is invalid");
        }
        this.min = min;
        this.hour = hour;
    }

    @Override
    public String toString() {
        return this.getHour() + ":" + this.getMin();
    }

//    @Override                                                             // solution
//    public String toString() {
//        return String.format("%02d:%02d", this.hour, this.minute);
//    }

    public int getHour() {
        return hour;
    }

    public int getMin() {
        return min;
    }


    public static void main(String[] args) {
        SimpleTime simpleTime = new SimpleTime(20, 45);
        System.out.println(simpleTime.toString());

//        SimpleTime simpleTime1 = new SimpleTime(25, 00);
//        System.out.println(simpleTime1.toString());
//
//        Exception in thread "main" exceptionclass.InvalidTimeException: Hour is invalid (0-23)
//        at exceptionclass.SimpleTime.<init>(SimpleTime.java:13)
//        at exceptionclass.SimpleTime.main(SimpleTime.java:68)


//        SimpleTime simpleTime2 = new SimpleTime(20, 78);
//        System.out.println(simpleTime2.toString());
//
//        Exception in thread "main" exceptionclass.InvalidTimeException: Minute is invalid (0-59)
//        at exceptionclass.SimpleTime.<init>(SimpleTime.java:16)
//        at exceptionclass.SimpleTime.main(SimpleTime.java:76)


        SimpleTime simpleTime3 = new SimpleTime("23:10");
        System.out.println(simpleTime3.toString());

//        SimpleTime simpleTime4 = new SimpleTime("23 : 10");
//        System.out.println(simpleTime3.toString());
//
//        Exception in thread "main" exceptionclass.InvalidTimeException: Time is not hh:mm
//        at exceptionclass.SimpleTime.<init>(SimpleTime.java:27)
//        at exceptionclass.SimpleTime.main(SimpleTime.java:87)


//        SimpleTime simpleTime5 = new SimpleTime("");
//        System.out.println(simpleTime5.toString());
//
//        Exception in thread "main" exceptionclass.InvalidTimeException: Time is null
//        at exceptionclass.SimpleTime.<init>(SimpleTime.java:24)
//        at exceptionclass.SimpleTime.main(SimpleTime.java:94)

        Course course = new Course("Java", new SimpleTime(8, 30));
        System.out.println(course.toString());

    }
}
