package collectionsmap;

import java.time.LocalDate;

public class Entry {

    private String ipAddress;
    private LocalDate date;
    private String login;

    public Entry(String ipAddress, String login, LocalDate date) {
        this.ipAddress = ipAddress;
        this.date = date;
        this.login = login;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getLogin() {
        return login;
    }
}
