package introdate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class PerformanceTest {
    public static void main(String[] args) {
        String artistName = "Queen";
        LocalDate performanceDate = LocalDate.of(1989, 06, 02);
        LocalTime startTime = LocalTime.of(18, 00);
        LocalTime endTime = LocalTime.of(20, 00);

        Performance performance1 = new Performance(artistName, performanceDate, startTime, endTime);

        System.out.println(performance1.getArtistName() + ": " + performance1.getPerformanceDate() + " " + performance1.getStartTime() + "-" + performance1.getEndTime());
    }
}
