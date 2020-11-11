package introdate;

import java.time.LocalDateTime;

public class Performance {
    private String artistName;
    private String performanceDate;
    private String startTime;
    private String endTime;

    public Performance(String artistName, String performanceDate, String startTime, String endTime) {
        this.artistName = artistName;
        this.performanceDate = performanceDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /*
    public String getInfo() {
        return
    }
    */

    public String getArtistName() {
        return artistName;
    }

    public String getPerformanceDate() {
        return performanceDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }
}
