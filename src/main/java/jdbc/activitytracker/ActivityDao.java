/*
Alkalmazás architektúra
Hozz létre egy ActivityDao osztályt, mely a következő metódusokat tartalmazza:

void saveActivity(Activity)
Activity findActivityById(long id)
List<Activity> listActivities()
Töröld ki az adatbázisban a táblát, és használd a Flyway-t, hogy hozza létre a sémát!

Írj egy JUnit integrációs tesztet az ActivityDao tesztelésére!
 */

package jdbc.activitytracker;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActivityDao {      // DAO = Data Access Object

    private DataSource dataSource;   // csak DataSource-t vár
            // -> bármilyen adatbázison működik, amihez kompatibilis ez az SQL leírás: MySQL, Microsoft SQL, Oracle SQL, MariaDB

    public ActivityDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insertActivity(Activity activity) {
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

//    public Activity selectById(long id) {
//        try(Connection conn = dataSource.getConnection();
//            PreparedStatement stmt = conn.prepareStatement("select * from activities where id = ?")
//        ) {
//            stmt.setLong(1, id);
//            return selectByPreparedStatement(stmt);
//        } catch (SQLException se) {
//            throw new IllegalStateException("Can not contact.", se);
//        }
//    }
//
//    private Activity selectByPreparedStatement(PreparedStatement stmt) {
//        try (ResultSet rs = stmt.executeQuery()){
//            if(rs.next()) {
//                Activity activity = new Activity(
//                        rs.getLong("id"),
//                        rs.getTimestamp("start_time").toLocalDateTime(),
//                        rs.getString("activity_desc"),
//                        ActivityType.valueOf(rs.getString("activity_type")));
//                return activity;
//            }
//            throw new IllegalArgumentException("Not found value.");
//        }
//        catch (SQLException se) {
//            throw new IllegalArgumentException("Wrong statement.", se);
//        }
//    }
//
//    public List<Activity> selectAllActivities() {
//        List<Activity> activities = new ArrayList<>();
//        try (Connection conn = dataSource.getConnection();
//             PreparedStatement stmt = conn.prepareStatement("select * from activities");
//             ResultSet rs = stmt.executeQuery();
//        ) {
//            while (rs.next()) {
//                Activity activity = new Activity(
//                        rs.getLong("id"),
//                        rs.getTimestamp("start_time").toLocalDateTime(),
//                        rs.getString("activity_desc"),
//                        ActivityType.valueOf(rs.getString("activity_type")));
//                activities.add(activity);
//            }
//            return activities;
//        } catch (SQLException se) {
//            throw new IllegalArgumentException("Can not connect", se);
//        }
//    }

    public Activity selectById(long id) {        // csak a Statement-t állítja elő
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement("select * from activities where id = ?")
        ) {
            stmt.setLong(1, id);
            List<Activity> result = selectByPreparedStatement(stmt);
            if(result.size()==1) {
                return result.get(0);
            }
            throw new IllegalArgumentException("Not found.");
        } catch (SQLException se) {
            throw new IllegalStateException("Can not contact.", se);
        }
    }

    private List<Activity> selectByPreparedStatement(PreparedStatement stmt) {      // select végrehajtása
        List<Activity> activities = new ArrayList<>();
        try (ResultSet rs = stmt.executeQuery()){
            while (rs.next()) {
                Activity activity = new Activity(
                        rs.getLong("id"),
                        rs.getTimestamp("start_time").toLocalDateTime(),
                        rs.getString("activity_desc"),
                        ActivityType.valueOf(rs.getString("activity_type")));
                activities.add(activity);
            }
            return activities;
        }
        catch (SQLException se) {
            throw new IllegalArgumentException("Wrong statement.", se);
        }
    }

    public List<Activity> selectAllActivities() {      // csak a Statement-t állítja elő

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("select * from activities");
        ) {
            return selectByPreparedStatement(stmt);
        } catch (SQLException se) {
            throw new IllegalArgumentException("Can not connect", se);
        }
    }



    public List<Activity> selectActivitiesByType(ActivityType type) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("select * from activities where activity_type = ?")
        ) {
            stmt.setString(1, type.toString());
            return selectByPreparedStatement(stmt);
        } catch (SQLException throwables) {
            throw new IllegalStateException("Connection failed", throwables);
        }
    }

}
