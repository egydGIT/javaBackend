package finalmodifier;

import static finalmodifier.CircleCalculator.PI;

public class PiMain {
    public static void main(String[] args) {
        System.out.println("PI = " + PI);

        double h = 20.4;
        double r = 9.7;

        CircleCalculator circleCalculator = new CircleCalculator();

        System.out.println("Kerület: " + circleCalculator.calculatePerimeter(r));
        System.out.println("Terület: " + circleCalculator.calculateArea(r));

        CylinderCalculator cylinderCalculator = new CylinderCalculator();

        System.out.println("Felület: " + cylinderCalculator.calculateSurfaceArea(r, h));
        System.out.println("Térfogat: " + cylinderCalculator.calculateVolume(r, h));
    }
}
