package localvariables;

public class DistanceMain {
    public static void main(String[] args) {
        Distance distance = new Distance();
        System.out.println(distance.getDistanceInKm());
        System.out.println(distance.isExact());

        double distanceInKm = 5.84;
        int i = (int) distanceInKm;
        System.out.println(i);

    }
}
