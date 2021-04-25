package jdbc_gyak.employees.architecture;

import org.flywaydb.core.Flyway;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.List;

public class EmployeesDaoMain {

    public static void main(String[] args) {

        MariaDbDataSource dataSource;
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
            dataSource.setUser("employees");
            dataSource.setPassword("employees");
        } catch (SQLException se) {
            throw new IllegalStateException();
        }

        // Flyway: olyan eszköz, ami helyettünk elkészíti a táblákat
        // pom.xml -ben fel kell venni dependeny közé

        // HeidiSQL-ben parancs:
        // create table employees(id bigint auto_increment, emp_name varchar(255), constraint pk_employees primary key(id));

//        Flyway flyway = new Flyway();             // régi módszer
//        flyway.setDataSource(dataSource);

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();   // Flyway obj. létrehozás
        flyway.migrate();

        flyway.clean();             // adatbázisban lévő összes táblát törli
        flyway.migrate();           // alkalmazásban: resources\db\migration könyvtárban lévő összes SQL áll-t lefuttatja


        EmployeesDao employeesDao = new EmployeesDao(dataSource);
        employeesDao.createEmployee("Jane Doe");

        List<String> names = employeesDao.listEmployeeNames();
        System.out.println(names);

        String name = employeesDao.findEmployeeNameById(1L);
        System.out.println(name);
    }
}