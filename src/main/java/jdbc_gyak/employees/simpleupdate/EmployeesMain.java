package jdbc_gyak.employees.simpleupdate;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;

public class EmployeesMain {

    // HeidiSQL-ben kaidott parancsok:
    /*
    create schema if not exists employees default character set utf8 collate UTF8_HUNGARIAN_CI;  -- employees adatbázis létrehozása

    create user 'employees'@'localhost' identified by 'employees';	-- employees felhaszn. létrehozása
    grant all on employees.* to 'employees'@'localhost';            -- jogosultságot ad az employees db-hoz az employees felhaszn-nak


    create table employees(id bigint auto_increment, emp_name varchar(255), constraint pk_employees primary key(id));
                                                                     -- employee tábla létrehozása

     */


    public static void main(String[] args) {

        MariaDbDataSource dataSource = new MariaDbDataSource();                             // 1. DataSource (nem kell lezárni)
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");   // JDBC URL beállítása
                // localhost-on futó adatbáz-hoz kapcsolódunk a 3306-on, employees adatb-ban lévő táblákhoz szeretnénk hozzáférni
            dataSource.setUser("employees");
            dataSource.setPassword("employees");
        } catch (SQLException se) {
            throw new IllegalStateException("Can not create data source", se);
        }


        // ADATBÁZISBA ÍRÁS:

        try (
                Connection conn = dataSource.getConnection();                               // 2. Connection (dataSource-ből)
                PreparedStatement stmt =                                                    // 3. PreparedStatement
                        conn.prepareStatement("INSERT INTO employees(emp_name) VALUES (?)",
                                                                // insert utasítás, paaraméterezve, place holder ?
                                Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, "John Doe");      // hanyadik ? helyére melyik értéket szeretnénk beszúrni
                                                                        // számozás 1-től
            stmt.executeUpdate();                               // felparaméterezett SQL-t elküldi az adatvbázisnak
        }
        catch (SQLException se) {
            throw new IllegalStateException("Can not insert", se);
        }


        // ADATBÁZISBÓL LEKÉRDEZÉS:

        try (Connection conn = dataSource.getConnection();          // java program hozzákapcsolódik az adatbázishoz
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select emp_name from employees");     // -> lekérdezés
                    // select: összes alkalmazott nevét leszelektálja, eredménytáblát ad vissza
                    // ResultSet tulképp egy tábla, a select eredményei vannak benne (semmi köze a Set-hez)
        ) {
            while (rs.next()) {                                     // eredménytáblán ciklusban végigiterál
                String name = rs.getString("emp_name");   // adott oszlophoz tartozó értékeket lekérdezi
                System.out.println(name);
            }
        } catch (SQLException se) {                 // try-with-resources: Connection, Statement, ResultSet lezárása
            throw new IllegalStateException("Can not select employees", se);
        }


    }
}