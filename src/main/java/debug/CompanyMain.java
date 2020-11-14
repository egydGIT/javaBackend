package debug;

import java.util.ArrayList;
import java.util.List;


public class CompanyMain {
    public static void main(String[] args) {
        Employee employee1 = new Employee("John Doe", 1985);   // Emloyee osztály páldányosítása
        Employee employee2 = new Employee("Jack Doe", 1960);   // 3 példány, értékei konstr-ral beállítva
        Employee employee3 = new Employee("Jane Doe", 1963);   // értékeit e1,2,3 változóba mentve

        Company company = new Company(new ArrayList<>());                     // Company osztály példányosítása

        company.addEmployee(employee1);                                      // konstru-ral beállított változók értékeit
        company.addEmployee(employee2);                                      // Company oszt-ban deklarált addE met-sal
        company.addEmployee(employee3);                                      // hozzáadom a lepéldányosított objektumhoz

        Employee jack = company.findEmployeeByName("Jack Doe");              // company nevű példányban adott péld-t keres
                                                                             // a Company oszt-ban dekl met-sal
                                                                             // amit elmentünk a jack változóba
        System.out.println(jack.getName() + " " + jack.getYearOfBirth());    // jack vált-ra meghívunk 2 met-t, ö.konkat.
                                                                             // jack vált. tartalmazza a lepéldányosított
                                                                             // obj-ban lévő listát

        List<String> names = company.listEmployeeNames();                    // lepéld-ott obj-ra hivatkozó vált-ra
                                                                             // meghívjuk a listE met-t
                                                                             // visszatérési ért-t elmentjük egy listába

        System.out.println(names);                                           // ezen lista kiiratása

    }






}
