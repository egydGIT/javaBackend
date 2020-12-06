package immutable;

public class Satellite {

    private String registerIdent;
    private CelestialCoordinates celestialCoordinates;


    public Satellite (CelestialCoordinates destinationCoordinates, String registerIdent) {

    }

    public void modifyDestination (CelestialCoordinates diff) {

    }

    public String getRegisterIdent() {
        return registerIdent;
    }

    public CelestialCoordinates getCelestialCoordinates() {
        return celestialCoordinates;
    }

    @Override
    public String toString() {
        return "Satellite{" +
                "registerIdent='" + registerIdent + '\'' +
                ", celestialCoordinates=" + celestialCoordinates +
                '}';
    }

    private boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }
}
