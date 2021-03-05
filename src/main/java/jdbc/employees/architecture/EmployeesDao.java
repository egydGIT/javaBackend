package jdbc.employees.architecture;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeesDao {         // DAO = Data Access Object, olyan obj, ami az adatokhoz fér hozzá
                                    // adatbázis műveleteket tartalmaz: lekérdező, módosító, beszúró, törlő
                                    // kül adatbázis műveletek külön met-ban, egy osztályban  -> Clean code!

    private DataSource dataSource;  // adatbázishoz kapcsolódás feltételeit tartalmazza:
                                    // domain név, felhasz név, jelszó, port, adatbázis neve

    public EmployeesDao(DataSource dataSource) {    // konstruktorban kapja meg
        this.dataSource = dataSource;
    }

    public void createEmployee(String name) {       // kapott név alapján új sort szúr be az adattáblába
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("INSERT INTO employees(emp_name) VALUES (?)",
                                Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, name);
            stmt.executeUpdate();
        }
        catch (SQLException se) {
            throw new IllegalStateException("Cannot insert");
        }
    }

    public List<String> listEmployeeNames() {       // select alapján visszakapott adatokat String listában adja vissza
        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select emp_name from employees")
        ) {
            List<String> names = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString("emp_name");
                names.add(name);
            }
            return names;
        }
        catch (SQLException se) {
            throw new IllegalStateException("Cannot select employees", se);
        }
    }

    public String findEmployeeNameById(long id) {       // id paraméter alapján kiveszi az azonosítóhoz tartozó nevet
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("select emp_name from employees where id = ?");
        ) {
            ps.setLong(1, id);

            return selectNameByPreparedStatement(ps);
        }
        catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
    }

    private String selectNameByPreparedStatement(PreparedStatement ps) {
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                String name = rs.getString("emp_name");
                return name;
            }
            throw new IllegalArgumentException("Not found");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
    }


}