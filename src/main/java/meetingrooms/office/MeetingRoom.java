package meetingrooms.office;

public class MeetingRoom {
    private String name;                                                    // Attributumok
    private int width;
    private int length;

    public MeetingRoom(String name, int width, int length) {                // Konstruktor
        this.name = name;
        this.width = width;
        this.length = length;
    }

    public int getArea() {                                                  // Metódus, területszámításra
        return width * length;
    }

    public String getName() {                                               // Getterek
        return name;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public void setName(String name) {                                      // Setterek
        this.name = name;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override                                                               // toString metódus
    public String toString() {
        return "\n " + "MeetingRoom-" +
                name.toUpperCase() + ": " +
                "width=" + width +
                ", length=" + length +
                ", area=" + getArea() ;
    }
}

