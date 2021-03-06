/*
Egyszerű JDBC adatmódosítás
Ellenőrizd, hogy fut-e a MySQL szerver a lokális számítógépen (localhost)!
Jelentkezz be root felhasználóval HeidiSQL kliens használatával, és futtasd le a következő parancsot:

use mysql;
create schema if not exists activitytracker default character set utf8 collate utf8_hungarian_ci;

create user 'activitytracker'@'localhost' identified by 'activitytracker';
grant all on *.* to 'activitytracker'@'localhost';
Ekkor létrejön az activitytracker séma, és az activitytracker felhasználó, ugyanezzel a jelszóval.

Írj egy activitytracker.Activity osztályt, mely attribútumai:

id - egyedi azonosító, egész szám
startTime - kezdési idő, LocalDateTime
desc - szöveges leírás
type - felsorolásos típus, mely felveheti a következő értékeket: BIKING, HIKING, RUNNING, BASKETBALL

Írj egy activitytracker.ActivityTrackerMain osztályt, mely egy main() metódusban,
mely példányosít pár Activity példányt, és értéküket beszúrja az activities táblába!
Az adatbázisban hozd létre az activities táblát! Az id legyen auto_generated!
A mezőnevek legyenek hasonlóak az osztály attribútumainak neveihez, azonban a szavakat aláhúzásjel (_) válassza el!
Mivel a desc és a type foglalt szó, ezért ezen oszlopok neve legyen activity_desc és activity_type.

A LocalDateTime értéket JDBC-vel a ResultSet.setTimestamp() metódussal lehet beszúrni.
Létrehozni a Timestamp.valueOf(LocalDateTime) metódussal lehet.

Amennyiben kész, szervezd ki a beszúrást egy külön metódusba!
 */

/*
Egyszerű JDBC lekérdezés
A main metódust egészítsd ki úgy, hogy kérdezz le egy rekordot id alapján az activities táblából.
A visszakapott ResultSet alapján példányosíts egy Activity típusú objektumot! Szervezd ki egy külön metódusba!

A main metódust egészítsd ki úgy, hogy kérdezd le az összes rekordot az activities táblából!
Példányosíts egy List<Activity> listát, amit feltöltesz a lekérdezett adatok alapján! Szervezd ki egy külön metódusba!
 */

package jdbc.activitytracker;

import java.time.LocalDateTime;

public class Activity {

    private long id;
    private LocalDateTime startTime;
    private String desc;
    private ActivityType type;

    // ha adatbázisból akarjuk lekérdezni, az ott lévő adatokat kell példányosítani (id-t is)
    public Activity(long id, LocalDateTime startTime, String desc, ActivityType type) {
        this.id = id;
        this.startTime = startTime;
        this.desc = desc;
        this.type = type;
    }

    // activity beszúrásakor példányosítani kell, de id-t az adatbázis generálja
    public Activity(LocalDateTime startTime, String desc, ActivityType type) {
        this.startTime = startTime;
        this.desc = desc;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public String getDesc() {
        return desc;
    }

    public ActivityType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", desc='" + desc + '\'' +
                ", type=" + type +
                '}';
    }


}
