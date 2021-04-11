package methodstructure.bmi;

public class BodyMass {

    public static double LOWER_LIMIT = 18.5;
    public static double UPPER_LIMIT = 25.0;

    private double weight;
    private double height;

    public BodyMass(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public double bodyMassIndex() {
        return weight / (height * height);
    }

    public BmiCategory body() {
        if (bodyMassIndex() < LOWER_LIMIT) {
            return BmiCategory.UNDERWEIGHT;
        } else if (bodyMassIndex() > UPPER_LIMIT) {
            return BmiCategory.OVERWEIGHT;
        } else {
            return BmiCategory.NORMAL;
        }
    }

    public boolean isThinnerThan(BodyMass other) {
        return this.bodyMassIndex() < other.bodyMassIndex();
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public static void main(String[] args) {
        BodyMass bodyMass1 = new BodyMass(58, 1.66);
        BodyMass bodyMass2 = new BodyMass(31, 1.38);

        System.out.println(bodyMass1.bodyMassIndex());
        System.out.println(bodyMass1.body());

        System.out.println(bodyMass2.bodyMassIndex());
        System.out.println(bodyMass2.body());

        System.out.println(bodyMass1.isThinnerThan(bodyMass2));
    }
}
