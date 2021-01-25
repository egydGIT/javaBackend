package meetingrooms.office;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Controller {

    private Office office = new Office();   // már az attributumban példányosítás, (met-ban is lehetne)
    // kezdőértéke null

    public void readOffice() {
        Scanner scanner = new Scanner(System.in);          // bekért válasz beolvasására Scanner példányosítás

        System.out.println("Hány db tárgyalót szeretne rögzíteni? ");
        int answerPiece = scanner.nextInt();                // Scanner nextInt met-val beolvassuk a választ
                                                                        // vált.névhez rendeljük
        scanner.nextLine();                                 // Enter beolvasására

        for (int i = 0; i < answerPiece; i++) {             // for ciklus: annyiszor fut le, mint amit a válaszban beolvasott
            System.out.println("Kérem adja meg a " + (i + 1) + ". tárgyaló nevét! ");  // bekéri az adatait, elmenti, nevet rendel hozzá
            String answerOfficeName = scanner.nextLine();

            System.out.println("Kérem adja meg a " + (i + 1) + ". tárgyaló szélességét (méterben)! ");
            int answerOfficeWidth = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Kérem adja meg a " + (i + 1) + ". tárgyaló hosszúságát (méterben)! ");
            int answerOfficeLength = scanner.nextInt();
            scanner.nextLine();

            MeetingRoom meetingRoom = new MeetingRoom(answerOfficeName, answerOfficeWidth, answerOfficeLength);
                // meetingRoom nevű obj. példányosítás a beirt adatok tárolására
            office.addMeetingRoom(meetingRoom);
                // office-ban deklarált add met-sal adja hozzá a meetingRooms listához a most példány-ott obj. mem.címét
        }
        System.out.println();
        System.out.println("ADATOK: ");
        System.out.println(office.getMeetingRooms());   // office-ban dekl. get met kiíratja a listát
                                                        // kellett rá toStringet hívni, mert a lista mem címek sorozata
    }

    public List<String> menu = Arrays.asList("1. Tárgyalók sorrendben", "2. Tárgyalók visszafele sorrendben",
            "3. Minden második tárgyaló", "4. Területek", "5. Keresés pontos név alapján",
            "6. Keresés névtöredék alapján", "7. Keresés terület alapján");

    public char[] printMenu() {                                     // Metódus menü kiíratására
        System.out.println();
        System.out.println("MENU");
        for (int m = 0; m < menu.size(); m++) {
            System.out.println(menu.get(m));
        }
        return new char[0];
    }

    public void runMenu() {
        System.out.println();
        System.out.println("Kérem a sorszám alapján válasszon a fenti menüpontok közül!");
        Scanner scanner = new Scanner(System.in);
        String prefix = scanner.nextLine();

        /*
        String choosenMenu = "";                            // Metódus választott menüpont kiíratására
        for(String iteralInMenu : menu) {
            if (iteralInMenu.startsWith(prefix)) {
                choosenMenu = iteralInMenu;
            }
        }
        System.out.println(choosenMenu);
        return prefix;

         */

        if (prefix.contains("1")){
            office.printNames();
        }
        if (prefix.contains("2")){
            office.printNamesReserve();
        }
        if (prefix.contains("3")){
            office.printEventNames();
        }

        if (prefix.contains("4")){
            office.printAreas();
        }

        if (prefix.contains("5")){
            System.out.println("5. Keresés pontos név alapján: ");
            System.out.println("Kérem adja meg a keresett tárgyaló pontos nevét! ");
            String answerMeetingRoomName = scanner.nextLine();

            office.printMeetingRoomsWithName(office.getMeetingRooms(), answerMeetingRoomName);
        }

        if (prefix.contains("6")){
            System.out.println("6. Keresés névtöredék alapján: ");
            System.out.println("Kérem adja meg a keresett tárgyaló nevének egy részét! ");
            String answerMeetingRoomNamePrefix = scanner.nextLine();

            office.printMeetingRoomsContains(office.getMeetingRooms(), answerMeetingRoomNamePrefix);
        }

        if (prefix.contains("7")) {
            System.out.println("7. Keresés terület alapján");
            System.out.println("Minimum mekkora tárgyalót keres?");
            int area = scanner.nextInt();
            scanner.nextLine();

            office.printAreasLargerThan(area);
        }

    }

    public static void main(String[] args) {
        Controller controller= new Controller();
        controller.readOffice();
        controller.printMenu();
        controller.runMenu();
    }


}

