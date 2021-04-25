package jdbc.simpleupdate;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeesMain {

    public static void main(String[] args) {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker?useUnicode=true");
            dataSource.setUser("employees");
            dataSource.setPassword("employees");
        } catch (SQLException throwables) {
            throw new IllegalStateException("Can not connect", throwables);
        }

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("insert into employees(emp_name) values (?)",
                                Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, "John Doe");
            stmt.executeUpdate();
        }
        catch (SQLException se) {
            throw new IllegalStateException("Can not insert", se);
        }
    }
}
