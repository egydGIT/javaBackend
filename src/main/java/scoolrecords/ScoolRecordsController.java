package scoolrecords;

public class ScoolRecordsController {

    public void initSchool() {

    }


    public static void main(String[] args) {
        ClassRecords classRecords = new ClassRecords();

        classRecords.listStudentNames();                            // 1.
        classRecords.findStudentByName();                           // 2.
        classRecords.addStudent();                                  // 3.
        classRecords.findStudentByName().removeStudent();           // 4.
        classRecords.repetition();                                  // 5.
        classRecords.calculateClassAverage();                       // 6.
        classRecords.calculateClassAverageBySubject();              // 7.
        classRecords.listSudyResults();                             // 8.
        classRecords.findStudentByName().calculateAverage();        // 9.
        classRecords.findStudentByName().calculateSubjectAverage(); // 10.
                                                                    // 11.
    }
}

/*
1. Diákok nevének listázása
2. Diák név alapján keresése
3. Diák létrehozása
4. Diák név alapján törlése
5. Diák feleltetése
6. Osztályátlag kiszámolása
7. Tantárgyi átlag kiszámolása
8. Diákok átlagának megjelenítése
9. Diák átlagának kiírása
10. Diák tantárgyhoz tartozó átlagának kiírása
11. Kilépés

 */