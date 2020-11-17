package week02.office;

import java.util.ArrayList;
import java.util.List;

public class Office {
    private List<MeetingRoom> meetingRooms = new ArrayList<>();     // Lista, MeetingRoom tip-ú, meetingRooms nevű

    public void addMeetingRoom(MeetingRoom meetingRoom) {            // Hozzáadja a listához a par-ként átadott adatokat
        meetingRooms.add(meetingRoom);
    }

    public void printNames() {
        System.out.println("1. Tárgyalók sorrendben: ");
        for (MeetingRoom meetingRoom : meetingRooms) {
            System.out.println(meetingRoom.getName());
        }
    }

    public void printNamesReserve() {
        System.out.println("2. Tárgyalók visszafele sorrendben: ");
        for (int i = meetingRooms.size() - 1; i >= 0; i--) {
            System.out.println(meetingRooms.get(i).getName());
        }
    }

    public void printEventNames() {
        System.out.println("3. Minden második tárgyaló: ");
        for (int i = 0; i < meetingRooms.size(); i += 2) {
            System.out.println(meetingRooms.get(i).getName());
        }
    }

    public void printAreas() {
        System.out.println("4. Területek: ");
        for (int i = 0; i < meetingRooms.size(); i++) {
            System.out.println(meetingRooms.get(i).getName().toUpperCase() + " " +
                    + meetingRooms.get(i).getWidth() + " * "
                    + meetingRooms.get(i).getLength() + " = "
                    + meetingRooms.get(i).getArea());
        }
    }
/*
    public void printAreas() {
        System.out.println("4. Területek: ");
        for (MeetingRoom meetingRoom : meetingRooms) {
            System.out.println(meetingRoom.getName().toUpperCase() + " " +
                + meetingRoom.getWidth() + " * "
                + meetingRoom.getLength() + " = "
                + meetingRoom.getArea());
        }
    }
*/

    public void printMeetingRoomsWithName(String answerMeetingRoomName) {
        // System.out.println("5. Keresés pontos név alapján: ");
        for (MeetingRoom meetingRoom : meetingRooms) {
            if (meetingRoom.equals(answerMeetingRoomName)) {
                System.out.println(meetingRoom.getName());                              // ........nem ír ki
            }
        }
    }

    public void printMeetingRoomsContains(String answerMeetingRoomNamePrefix) {
        // System.out.println("6. Keresés névtöredék alapján: ");
        for (int i = 0; i < meetingRooms.size(); i++) {
            if (meetingRooms.contains(answerMeetingRoomNamePrefix.toLowerCase())) {
                System.out.println(meetingRooms.get(i).toString());                     // ........nem ír ki
            }
        }
    }

    public void printAreasLargerThan(int area) {
        // System.out.println("7. Keresés terület alapján");
        for (MeetingRoom meetingRoom : meetingRooms) {
            if (meetingRoom.getArea() > area) {
                System.out.println(meetingRoom.getName() + " (" + meetingRoom.getWidth()
                        + " * "  + meetingRoom.getLength() + " = " + meetingRoom.getArea() + ")");
            }
        }
    }


    public List<MeetingRoom> getMeetingRooms() {                            // Getter, Setter
        return meetingRooms;
    }

    public void setMeetingRooms(List<MeetingRoom> meetingRooms) {
        this.meetingRooms = meetingRooms;
    }

}
