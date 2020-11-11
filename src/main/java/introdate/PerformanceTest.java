package introdate;

import java.time.LocalDateTime;

public class PerformanceTest {
    public static void main(String[] args) {
        String artistName = "Queen";
        String performanceDate = "1989-06-02";
        String startTime = "18:00";
        String endTime = "20:00";

        Performance performance1 = new Performance(artistName, performanceDate, startTime, endTime);

        System.out.println(performance1.getArtistName() + ": " + performance1.getPerformanceDate() + " " + performance1.getStartTime() + "-" + performance1.getEndTime());
    }
}
