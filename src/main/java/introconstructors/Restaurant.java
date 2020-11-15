package introconstructors;

import java.util.Arrays;
import java.util.List;

public class Restaurant {
    private List<String> menu;
    private String name;
    private int numberOfTables;
    private int capacity;

    public Restaurant(String name, int numberOfTables) {
        this.name = name;
        this.numberOfTables = numberOfTables;
        capacity = 4 * numberOfTables;
        menu = getMenu();
    }

    private List<String> createMenu() {
        return Arrays.asList("Fish with potato", "Smoked salmon with vegetables");
    }

    public List<String> getMenu() {
        return menu = createMenu();
    }

    public String getName() {
        return name;
    }

    public int getNumberOfTables() {
        return numberOfTables;
    }

    public int getCapacity() {
        return capacity;
    }
}
