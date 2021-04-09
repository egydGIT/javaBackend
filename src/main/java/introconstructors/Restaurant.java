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
        this.capacity = 4 * numberOfTables;
        this.menu = createMenu();
    }

    private List<String> createMenu() {
        return Arrays.asList("Fish with potato", "Smoked salmon with vegetables");
    }

    public List<String> getMenu() {
        return menu;
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
