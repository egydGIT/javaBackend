package jdbc.simplequery;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;

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

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("select emp_name from employees where id = ?");
        ) {
            ps.setLong(1, 1L);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("emp_name");
                    System.out.println(name);
                }
            } catch (SQLException sqle) {
                throw new IllegalStateException("Cannot query", sqle);
            }
        }
        catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
    }
}
