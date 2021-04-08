package introdate;

import java.time.LocalDate;
import java.time.LocalTime;

public class Performance {
    private String artistName;
    private LocalDate performanceDate;
    private LocalTime startTime;
    private LocalTime endTime;

    public Performance(String artistName, LocalDate performanceDate, LocalTime startTime, LocalTime endTime) {
        this.artistName = artistName;
        this.performanceDate = performanceDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getInfo() {
        return getArtistName() + ": " + getPerformanceDate() + " " + getStartTime() + "-" + getEndTime();
    }

    public String getArtistName() {
        return artistName;
    }

    public LocalDate getPerformanceDate() {
        return performanceDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
}
