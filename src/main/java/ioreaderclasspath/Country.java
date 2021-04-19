package ioreaderclasspath;

public class Country {

    private String countryName;
    private int numberOfNeighbours;

    public Country(String countryName, int numberOfNeighbours) {
        this.countryName = countryName;
        this.numberOfNeighbours = numberOfNeighbours;
    }

    public String getCountryName() {
        return countryName;
    }

    public int getNumberOfNeighbours() {
        return numberOfNeighbours;
    }
}
