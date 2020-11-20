package week02.office;

import java.util.ArrayList;
import java.util.List;

public class Office {
    private List<MeetingRoom> meetingRooms = new ArrayList<>();     // Lista, MeetingRoom tip-ú, meetingRooms nevű

    public void addMeetingRoom(MeetingRoom meetingRoom) {            // Hozzáadja a listához a par-ként átadott adatokat
        meetingRooms.add(meetingRoom);
    }

    public void printNames() {                                                  //  1.
        System.out.println("1. Tárgyalók sorrendben: ");
        for (MeetingRoom meetingRoom : meetingRooms) {
            System.out.println(meetingRoom.getName());
        }
    }

    public void printNamesReserve() {                                           // 2.
        System.out.println("2. Tárgyalók visszafele sorrendben: ");
        for (int i = meetingRooms.size() - 1; i >= 0; i--) {
            System.out.println(meetingRooms.get(i).getName());
        }
    }

    public void printEventNames() {                                             // 3.
        System.out.println("3. Minden második tárgyaló: ");
        for (int i = 0; i < meetingRooms.size(); i += 2) {
            System.out.println(meetingRooms.get(i).getName());
        }
    }

    public void printAreas() {                                                  // 4. - for ciklus
        System.out.println("4. Területek: ");
        for (int i = 0; i < meetingRooms.size(); i++) {
            System.out.println(meetingRooms.get(i).getName().toUpperCase() + " " +
                    + meetingRooms.get(i).getWidth() + " * "
                    + meetingRooms.get(i).getLength() + " = "
                    + meetingRooms.get(i).getArea());
        }
    }
/*
    public void printAreas() {                                                  // 4. - for-each ciklus
        System.out.println("4. Területek: ");
        for (MeetingRoom meetingRoom : meetingRooms) {
            System.out.println(meetingRoom.getName().toUpperCase() + " " +
                + meetingRoom.getWidth() + " * "
                + meetingRoom.getLength() + " = "
                + meetingRoom.getArea());
        }
    }
*/
                                                                                // 5. Szürés
    public List<MeetingRoom> printMeetingRoomsWithName(List<MeetingRoom> meetingRooms, String answerMeetingRoomName) {
        // System.out.println("5. Keresés pontos név alapján: ");
        List<MeetingRoom> filteredNames = new ArrayList<>();
        for (MeetingRoom meetingRoom : meetingRooms) {
            if (meetingRoom.getName().equals(answerMeetingRoomName)) {
                filteredNames.add(meetingRoom);
            }
        }
        System.out.println(filteredNames.toString());
        return filteredNames;
    }

/*
    public void printMeetingRoomsWithName(String answerMeetingRoomName) {         // 5. equals met-sal
        // System.out.println("5. Keresés pontos név alapján: ");
        for (MeetingRoom meetingRoom : meetingRooms) {
            if (meetingRoom.equals(answerMeetingRoomName)) {
                System.out.println(meetingRoom.getName());                              // ........nem ír ki
            }
        }
    }

 */
                                                                                   // 6. Szűrés
    public List<MeetingRoom> printMeetingRoomsContains(List<MeetingRoom> meetingRooms, String answerMeetingRoomNamePrefix) {
        // System.out.println("6. Keresés névtöredék alapján: ");
        List<MeetingRoom> filteredNamesWithPrefix = new ArrayList<>();
        for (MeetingRoom meetingRoom : meetingRooms) {
            if (meetingRoom.getName().contains(answerMeetingRoomNamePrefix)) {
                filteredNamesWithPrefix.add(meetingRoom);
            }
        }
        System.out.println(filteredNamesWithPrefix.toString());
        return filteredNamesWithPrefix;
    }
/*
                                                                                    // 6. contains met-sal
    public void printMeetingRoomsContains(String answerMeetingRoomNamePrefix) {
        // System.out.println("6. Keresés névtöredék alapján: ");
        for (int i = 0; i < meetingRooms.size(); i++) {
            if (meetingRooms.contains(answerMeetingRoomNamePrefix.toLowerCase())) {
                System.out.println(meetingRooms.get(i).toString());                     // ........nem ír ki
            }
        }
    }
 */

    public void printAreasLargerThan(int area) {                                     // 7.
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
