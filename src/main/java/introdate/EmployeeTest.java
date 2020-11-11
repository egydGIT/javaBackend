package introdate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class EmployeeTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Alkalmazott neve: ");
        String name = scanner.nextLine();

        System.out.println("Alkalmazott születési dátuma: ");
        LocalDate dateOfBirth = LocalDate.ofEpochDay(scanner.nextInt());
        // String dateOfBirth = scanner.nextLine();

        System.out.println("Mukábalépés kezdete: ");
        LocalDateTime beginEmployment = LocalDateTime.parse(scanner.nextLine());
        // String beginEmployment = scanner.nextLine();

        LocalDateTime dateTime = LocalDateTime.now();
        Employee employee1 = new Employee(name, dateOfBirth, beginEmployment);

        System.out.println("Név: " + employee1.getName() );
        System.out.println("Szüelési dátum: " + employee1.getDateOfBirth() );
        System.out.println("Munkábalépés kezdete: " + employee1.getBeginEmployment() );

    }
}
