package jdbc.activitytracker;

import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;

public class ActivityTrackerMain {

    public void insertActivity(DataSource dataSource, Activity activity) {
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt =
                    conn.prepareStatement("insert into activities(start_time, activity_desc, activity_type) values (?,?,?)")
        ) {
            // A LocalDateTime értéket JDBC-vel a ResultSet.setTimestamp() metódussal lehet beszúrni.
            // Létrehozni a Timestamp.valueOf(LocalDateTime) metódussal lehet.
            stmt.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            stmt.setString(2, activity.getDesc());
            stmt.setString(3, activity.getType().toString());
            stmt.executeUpdate();
        } catch (SQLException se) {
            throw new IllegalStateException("Can not connect", se);
        }
    }

    public Activity selectById(DataSource dataSource, long id) {
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement("select * from activities where id = ?")
        ) {
            stmt.setLong(1, id);
            return selectByPreparedStatement(stmt);
        } catch (SQLException se) {
            throw new IllegalStateException("Can not contact.", se);
        }
    }

    private Activity selectByPreparedStatement(PreparedStatement stmt) {
        try (ResultSet rs = stmt.executeQuery()){
            if(rs.next()) {
                Activity activity = new Activity(
                        rs.getLong("id"),
                        rs.getTimestamp("start_time").toLocalDateTime(),
                        rs.getString("activity_desc"),
                        ActivityType.valueOf(rs.getString("activity_type")));
                return activity;
            }
            throw new IllegalArgumentException("Not found value.");
        }
        catch (SQLException se) {
            throw new IllegalArgumentException("Wrong statement.", se);
        }
    }


    public static void main(String[] args) {
        MariaDbDataSource dataSource;

        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker?useUnicode=true");
            dataSource.setUser("activitytracker");
            dataSource.setPassword("activitytracker");
        } catch (SQLException se) {
            throw new IllegalStateException("Can not connect", se);
        }

        Activity activity1 = new Activity(LocalDateTime.of(2021, 2, 22, 10, 00), "Biking in Bükk 1", ActivityType.BIKING);
        Activity activity2 = new Activity(LocalDateTime.of(2021, 2, 23, 10, 00), "Biking in Bükk 2", ActivityType.BIKING);
        Activity activity3 = new Activity(LocalDateTime.of(2021, 2, 24, 10, 00), "Biking in Bükk 3", ActivityType.BIKING);

        ActivityTrackerMain activityTrackerMain = new ActivityTrackerMain();
        activityTrackerMain.insertActivity(dataSource, activity1);
        activityTrackerMain.insertActivity(dataSource, activity2);
        activityTrackerMain.insertActivity(dataSource, activity3);

        System.out.println(activityTrackerMain.selectById(dataSource, 3));

    }
}
