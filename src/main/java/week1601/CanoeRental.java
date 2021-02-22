package week1601;

import java.time.Duration;
import java.time.LocalDateTime;

public class CanoeRental {

    private String name;
    private CanoeType canoeType;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public CanoeRental(String name, CanoeType canoeType, LocalDateTime startTime) {
        this.name = name;
        this.canoeType = canoeType;
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public double calculateRentalSum(CanoeRental canoeRental) {
        LocalDateTime beginDate = canoeRental.getStartTime();
        LocalDateTime endDate = canoeRental.getEndTime();
        if ( canoeRental.getEndTime() == null ) {
            throw new IllegalArgumentException("This rental is still active. " + name);
        }
        return Duration.between(beginDate, endDate).toHours();
    }

    public String getName() {
        return name;
    }

    public CanoeType getCanoeType() {
        return canoeType;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }
}
