package immutable;

public class Satellite {

    private String registerIdent;
    private CelestialCoordinates destinationCoordinates;

    public Satellite(CelestialCoordinates destinationCoordinates, String registerIdent) {
        if (isEmpty(registerIdent)) {
            throw new IllegalArgumentException("Register ident must not be empty!");
        }
        this.registerIdent = registerIdent;
        this.destinationCoordinates = destinationCoordinates;
    }

    public void modifyDestination (CelestialCoordinates diff) {
        destinationCoordinates = new CelestialCoordinates(destinationCoordinates.getX() + diff.getX(),
                destinationCoordinates.getY() + diff.getY(), destinationCoordinates.getZ() + diff.getZ());
    }

    public String getRegisterIdent() {
        return registerIdent;
    }

    public CelestialCoordinates getDestinationCoordinates() {
        return destinationCoordinates;
    }

    @Override
    public String toString() {
        return registerIdent + ": " + destinationCoordinates.toString();
    }

    private boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }
}
