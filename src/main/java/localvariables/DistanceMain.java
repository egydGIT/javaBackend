package localvariables;

public class DistanceMain {

    public static void main(String[] args) {
        Distance distance = new Distance(5.84, false);
        System.out.println("Távolság: " + distance.getDistanceInKm());
        System.out.println("Pontosság: " + distance.isExact());

        // double distanceInKm = 5.84;
        // int i = (int) distanceInKm;
        int i = (int) distance.getDistanceInKm();
        System.out.println("Egész rész: " + i);

    }
}
