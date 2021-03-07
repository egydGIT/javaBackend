package jdbc.activitytracker;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ActivityDaoTest {

    ActivityDao activityDao;

    // teszteseteknek függetleneknek kell lenniük egymástól
    // minden teszteset előtt adatbzis inicializálás kell

    @BeforeEach
    public void init() {
        MariaDbDataSource dataSource;       // adatbázist itt konkretizáltuk

        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker?useUnicode=true");
            dataSource.setUser("activitytracker");
            dataSource.setPassword("activitytracker");
        } catch (SQLException se) {
            throw new IllegalStateException("Can not connect", se);
        }

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

        activityDao = new ActivityDao(dataSource);
    }

    @Test
    public void testInsertElement() {
        Activity activity1 = new Activity(LocalDateTime.of(2021, 2, 22, 10, 00), "Biking in Bükk 1", ActivityType.BIKING);
        activityDao.insertActivity(activity1);

        assertEquals(activityDao.selectAllActivities().size(), 2);
    }

    @Test
    public void testSelectByType() {
        assertEquals(activityDao.selectActivitiesByType(ActivityType.BIKING).size(), 1);    // V3__activities.sql fájlból jön
        assertEquals(activityDao.selectActivitiesByType(ActivityType.RUNNING).size(), 1);
    }


}