package jdbc_gyak.activitytracker;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActivityDao {      // DAO = Data Access Object

    private DataSource dataSource;   // csak DataSource-t vár
            // -> bármilyen adatbázison működik, amihez kompatibilis ez az SQL leírás: MySQL, Microsoft SQL, Oracle SQL, MariaDB

    public ActivityDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

////
//    public void insertActivity(Activity activity) {
//        try(Connection conn = dataSource.getConnection();
//            PreparedStatement stmt =
//                    conn.prepareStatement("insert into activities(start_time, activity_desc, activity_type) values (?,?,?)")
//        ) {
//                  // A LocalDateTime értéket JDBC-vel a ResultSet.setTimestamp() metódussal lehet beszúrni.
//                  // Létrehozni a Timestamp.valueOf(LocalDateTime) metódussal lehet.
//            stmt.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
//            stmt.setString(2, activity.getDesc());
//            stmt.setString(3, activity.getType().toString());
//            stmt.executeUpdate();
//        } catch (SQLException se) {
//            throw new IllegalStateException("Can not connect", se);
//        }
//    }

    public Activity insertActivity(Activity activity) {
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt =
                    conn.prepareStatement("insert into activities(start_time, activity_desc, activity_type) values (?,?,?)",
                                            Statement.RETURN_GENERATED_KEYS)        // konstans a kulcsok visszakérésére
        ) {
            stmt.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            stmt.setString(2, activity.getDesc());
            stmt.setString(3, activity.getType().toString());
            stmt.executeUpdate();
            return getIdFromStatement(activity, stmt);
        } catch (SQLException se) {
            throw new IllegalStateException("Can not connect", se);
        }
    }

    public Activity insertActivityTransaction(Activity activity) {
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt =
                    conn.prepareStatement("insert into activities(start_time, activity_desc, activity_type) values (?,?,?)",
                            Statement.RETURN_GENERATED_KEYS)        // konstans a kulcsok visszakérésére
        ) {
            stmt.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            stmt.setString(2, activity.getDesc());
            stmt.setString(3, activity.getType().toString());
            stmt.executeUpdate();

            Activity result = getIdFromStatement(activity, stmt);
            insertActivityTrackPoints(activity.getTrackPoints(), result.getId());
            return result;
        } catch (SQLException se) {
            throw new IllegalStateException("Can not connect", se);
        }
    }


    private void insertActivityTrackPoints(List<TrackPoint> trackPoints, long activityId) {
        try(Connection conn = dataSource.getConnection()) {
            conn.setAutoCommit(false);
            try (PreparedStatement stmt =
                         conn.prepareStatement("insert into track_points(actual_time, lat, lon, activity_id) values (?,?,?,?)")) {
                for (TrackPoint trackPoint: trackPoints) {
                    if(!isValidLatLon(trackPoint.getLat(), trackPoint.getLon())) {
                        throw new IllegalArgumentException("Invalid lat or lon.");
                    }
                    stmt.setDate(1, Date.valueOf(trackPoint.getTime()));
                    stmt.setDouble(2, trackPoint.getLat());
                    stmt.setDouble(3, trackPoint.getLon());
                    stmt.setLong(4, activityId);
                    stmt.executeUpdate();
                }
                conn.commit();
            } catch (IllegalArgumentException iae) {
                conn.rollback();
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Can not connect.", se);
        }
    }

    private boolean isValidLatLon(double lat, double lon) {
        if ( lat > 90 || lat <-90 ) {
            return false;
        }
        if ( lon > 180 || lon < -180 ) {
            return false;
        }
        return true;
    }

    private Activity getIdFromStatement(Activity activity, PreparedStatement stmt) throws SQLException {
        try (ResultSet rs = stmt.getGeneratedKeys()){       // ez adja vissza a kulcsokat
            if (rs.next()) {
                long id = rs.getLong(1);
                return new Activity(id, activity.getStartTime(), activity.getDesc(), activity.getType());
            }
            throw new IllegalStateException("Can not get key");
        }
    }

    public String createStatementForMoreInsert(int numberOfElements) {
        StringBuilder sb = new StringBuilder("insert into activities(start_time, activity_desc, activity_type");
        for (int i = 0; i < numberOfElements; i++ ) {
            sb.append("(?,?,?)");
        }
        return sb.toString();
    }
////
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
////
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
////
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
////
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

    public Activity selectBothById(long id) {
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement("select * from activities where id = ?");
            PreparedStatement stmt2 = conn.prepareStatement("select * from track_points where activity_id = ?")
        ) {
            stmt.setLong(1, id);
            List<Activity> result = selectByPreparedStatement(stmt); // egy id-val csak egy Activity van a listában
            if(result.size()==1) {
                stmt2.setLong(1, id);
                List<TrackPoint> resultPoints = selectTrackPointsByPreparedStatement(stmt2);
                result.get(0).addTrackPoints(resultPoints);
                return result.get(0);
            }
            throw new IllegalArgumentException("Not found.");
        } catch (SQLException se) {
            throw new IllegalStateException("Can not contact.", se);
        }
    }
////
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

    private List<TrackPoint> selectTrackPointsByPreparedStatement(PreparedStatement stmt) {
        List<TrackPoint> trackPoints = new ArrayList<>();
        try (ResultSet rs = stmt.executeQuery()){
            while (rs.next()) {
                TrackPoint trackPoint = new TrackPoint(
                        rs.getLong("id"),
                        rs.getDate("actual_time").toLocalDate(),
                        rs.getDouble("lat"),
                        rs.getDouble("lon"));
                trackPoints.add(trackPoint);
            }
            return trackPoints;
        }
        catch (SQLException se) {
            throw new IllegalArgumentException("Wrong statement.", se);
        }
    }
////
    public List<Activity> selectAllActivities() {      // csak a Statement-t állítja elő

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("select * from activities");
        ) {
            return selectByPreparedStatement(stmt);
        } catch (SQLException se) {
            throw new IllegalArgumentException("Can not connect", se);
        }
    }


////
    public List<Activity> selectActivitiesByType(ActivityType type) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("select * from activities where activity_type = ?")
        ) {
            stmt.setString(1, type.name());
            return selectByPreparedStatement(stmt);
        } catch (SQLException throwables) {
            throw new IllegalStateException("Connection failed", throwables);
        }
    }
////
    public List<Activity> activitiesBeforeDate(LocalDate date) {   // par-ben kapott dátum előtti activity-ket adja vissza listában
       try (Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement("select * from activities where start_time < ?")
       ) {
           // stmt.setTimestamp(1, Timestamp.valueOf(date));                 // ha param: LocalDateTime date
           LocalDateTime actualDate = date.atTime(0,0);          // ha param: LocalDate date
           stmt.setTimestamp(1, Timestamp.valueOf(actualDate));
           return  selectByPreparedStatement(stmt);
       } catch (SQLException se) {
           throw new IllegalStateException("Can not connect.", se);
       }
    }

}

