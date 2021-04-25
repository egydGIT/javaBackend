package jdbc_gyak.activitytracker;

import org.flywaydb.core.Flyway;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;
import java.time.LocalDateTime;

public class ActivityTrackerMain {

    // itt lévő met-kat átmozgattuk az ActivityDao oszt-ba -> ez az oszt. felelős az adatbázis kapcsolatért

    public static void main(String[] args) {
        MariaDbDataSource dataSource;       // adatbázist itt konkretizáltuk

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


        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();


        ActivityDao activityDao = new ActivityDao(dataSource); // dataSource nem kell met. param-ként, mert megkapja konstr-ban
        activityDao.insertActivity(activity1);
        activityDao.insertActivity(activity2);
        activityDao.insertActivity(activity3);

        System.out.println(activityDao.selectById(3));

        System.out.println(activityDao.selectAllActivities());

        System.out.println(activityDao.selectActivitiesByType(ActivityType.BIKING));

    }
}
