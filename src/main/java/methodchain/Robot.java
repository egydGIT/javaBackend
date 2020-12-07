package methodchain;

import java.util.ArrayList;
import java.util.List;

public class Robot {
    private int distance;
    private int azimut;
    private List<NavigationPoint> navigationPointList = new ArrayList<>();

    public Robot go (int meter) {         // azzal az objektum példánnyal tér vissza, amire meghívtuk, emiatt láncolható
        this.distance += meter;           // eddig megtett összes távolsághoz a par. értékét hozzáadja
        return this;
    }

    public Robot rotate (int angle) {
        this.azimut += angle;             // aktuális irányszöget változtatja
        return this;
    }

    public Robot registerNavigationPoint() {  // regisztrálja az egymás után következő pozíciók sorozatát
        this.navigationPointList.add(new NavigationPoint(this.distance, this.azimut));
                                        // távolság és szög ismeretében lepéldányosít egy obj-ot, amit hozzáad a listához
        return this;
    }

    public NavigationPoint build() {            // build metódus - próbálkozás..
        return new NavigationPoint(distance, azimut);
    }

    public int getDistance() {
        return distance;
    }

    public int getAzimut() {
        return azimut;
    }

    public List<NavigationPoint> getNavigationPointList() {
        return navigationPointList;
    }

    public String toString(){
        return "distance: " + distance + "cm " + " azimut: " + azimut + "°";
    }

    public static void main(String[] args) {
        // NavigationPoint osztály:
        NavigationPoint navigationPoint = new NavigationPoint(45, 90);
        System.out.println(navigationPoint.toString());
        System.out.println(navigationPoint.getActualDistance());
        System.out.println(navigationPoint.getActualAzimut());

        // Robot osztály:
        Robot robot1 = new Robot().go(17).rotate(90);
        System.out.println(robot1.registerNavigationPoint().toString());
        System.out.println(robot1.getDistance());
        System.out.println(robot1.getAzimut());

        // build
        Robot robot3 = new Robot().go(15).rotate(0);
        System.out.println(robot3.build());

        // toString a két osztályban azért különböző, h lássam melyik met, melyiket hívja meg


        /*
        //Bónusz feladat tesztje, kommentezd ki az alapfeladathoz
        @Test
        public void testNavigationChain() {
            //When
            robot.go(5).rotate(45).registerNavigationPoint().go(10).rotate(-15).registerNavigationPoint();
            //Then
            assertEquals("[distance: 5 azimut: 45, distance: 15 azimut: 30]", robot.getNavigationList().toString());
        }

         */

        // navigationPointList
        Robot robot2 = new Robot().go(5).rotate(90).registerNavigationPoint()
                                    .go(40).rotate(-90).registerNavigationPoint()
                                    .go(-30).rotate(10).registerNavigationPoint();
        System.out.println("Több lépés együtt: " + robot2.registerNavigationPoint().toString());

    }
}
