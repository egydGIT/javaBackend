/*
Junior
Írj egy a TemplateMerger osztályba egy public String merge(Path file, List<Employee> employees) metódust,
ami felolvassa a fájlt, melynek tartalma:

Az alkalmazott neve: {nev}, születési éve: {ev}

Nyugodtan beolvashatod egy utasítással!
Majd a visszatérési értékként add vissza soronként az alkalmazottakat, abban a formátumban, mint ahogy a fájlban van, azaz:

Az alkalmazott neve: John Doe, születési éve: 1980
Az alkalmazott neve: Jack Doe, születési éve: 1990

Persze ehhez kell egy Employee osztály is a megfelelő attribútumokkal.
 */

package week13d04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TemplateMerger {

    public String merge(Path file, List<Employee> employees) {
        try {
            String line = Files.readString(file);       // egy utasítással szöveges áll beolvasása
            StringBuilder sb = new StringBuilder();     // ciklusban String konkatenálására
            // System.out.println(line);                // line vált-ban a beolvasott sablon
            for (Employee employee: employees) {
                String replaced = line.replace("{nev}", employee.getName());        // replace holder: {nev}
                replaced = replaced.replace("{ev}", Integer.toString(employee.getYearOfBirth()));
                sb.append(replaced).append("\n");       // fluent api = met láncolás
                // System.out.println(replaced);        // replace vált-ban a sablon kicserélt aktuális adatokkal
            }
            return sb.toString();
        } catch (IOException e) {
            throw new IllegalStateException("Can not read file.", e);
        }
    }

    public static void main(String[] args) {
        Path path = Path.of("src/main/resources/employee-template.txt");
        List<Employee> employees = List.of(
                new Employee("John Doe", 1980),
                new Employee("Jack Doe", 1990));

        String result = new TemplateMerger().merge(path, employees);
        System.out.println(result);
    }

}
