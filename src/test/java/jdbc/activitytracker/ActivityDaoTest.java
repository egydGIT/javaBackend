package jdbc.activitytracker;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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

        Flyway flyway = Flyway.configure()                          // flyway location a db/migration könyvtáron belül
                .locations("/db/migration/activitytracker")
                .dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

        activityDao = new ActivityDao(dataSource);
    }

    @Test
    public void testInsertElement() {
        Activity activity1 = new Activity(LocalDateTime.of(2021, 2, 22, 10, 00), "Biking in Bükk 1", ActivityType.BIKING);
        activityDao.insertActivity(activity1);

        assertEquals(activityDao.selectAllActivities().size(), 4);
    }

    @Test
    public void testSelectByType() {
        assertEquals(activityDao.selectActivitiesByType(ActivityType.BIKING).size(), 1);    // V3__activities.sql fájlból jön
        assertEquals(activityDao.selectActivitiesByType(ActivityType.RUNNING).size(), 1);
    }

    @Test
    public void testActivitiesBeforeData() {
        assertEquals(activityDao.activitiesBeforeDate(LocalDate.of(2021, 02, 02)).size(), 1);
    }

    @Test
    public void testCreateStatementForMoreInsert() {
        System.out.println(activityDao.createStatementForMoreInsert(5));
        // insert into activities(start_time, activity_desc, activity_type(?,?,?)(?,?,?)(?,?,?)(?,?,?)(?,?,?)
    }

    @Test
    public void testFindById() {
        Activity activity = new Activity(LocalDateTime.now(), "Biking at home", ActivityType.BIKING);
        Activity result = activityDao.insertActivity(activity);

        assertEquals(activity.getDesc(), activityDao.selectById(result.getId()).getDesc());
    }

    @Test
    public void testInsertActivityWithTrackPoints() {
        Activity activity1 = new Activity(LocalDateTime.of(2021, 2, 22, 10, 00), "Biking in Bükk 1", ActivityType.BIKING);
        activity1.addTrackPoints(List.of(
                new TrackPoint(LocalDate.of(2021, 02, 20), 67, 23),
                new TrackPoint(LocalDate.of(2021, 02, 20), 67, 23),
                new TrackPoint(LocalDate.of(2021, 02, 20), 67, 23)));
                                            // ha nem valid adat, teszt lefut, de nem szúr be a táblába semmit

        Activity ac = activityDao.insertActivityTransaction(activity1);

        System.out.println(activityDao.selectBothById(ac.getId()));
    }

}