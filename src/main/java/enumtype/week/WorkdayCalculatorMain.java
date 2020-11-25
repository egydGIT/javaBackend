package enumtype.week;

import enumtype.week.Day;
import enumtype.week.WorkdayCalculator;

public class WorkdayCalculatorMain {
    public static void main(String[] args) {
        System.out.println(new WorkdayCalculator().dayTypes(Day.TUESDAY, 8));
    }
}
