package jdbc_gyak.activitytracker;

import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActivityTrackerMain2in1 {

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

        public Activity selectById(DataSource dataSource, long id) {        // csak a Statement-t állítja elő
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

        public List<Activity> selectAllActivities(DataSource dataSource) {      // csak a Statement-t állítja elő

            try (Connection conn = dataSource.getConnection();
                 PreparedStatement stmt = conn.prepareStatement("select * from activities");
            ) {
                return selectByPreparedStatement(stmt);
            } catch (SQLException se) {
                throw new IllegalArgumentException("Can not connect", se);
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

            ActivityTrackerMain2in1 activityTrackerMain = new ActivityTrackerMain2in1();
            activityTrackerMain.insertActivity(dataSource, activity1);
            activityTrackerMain.insertActivity(dataSource, activity2);
            activityTrackerMain.insertActivity(dataSource, activity3);

            System.out.println(activityTrackerMain.selectById(dataSource, 3));

            System.out.println(activityTrackerMain.selectAllActivities(dataSource));

        }
}


