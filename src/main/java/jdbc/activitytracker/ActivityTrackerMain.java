package jdbc.activitytracker;

import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

        ActivityDao activityDao = new ActivityDao(dataSource);
        activityDao.insertActivity(dataSource, activity1);
        activityDao.insertActivity(dataSource, activity2);
        activityDao.insertActivity(dataSource, activity3);

        System.out.println(activityDao.selectById(dataSource, 3));

        System.out.println(activityDao.selectAllActivities(dataSource));

    }
}
