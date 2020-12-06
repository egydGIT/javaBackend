package methodvarargs;

public class ExamStats {
    private double maxPoints;
    private int limitInPerCent;

    public ExamStats(int maxPoints) {                               // konstruktor
        this.maxPoints = maxPoints;
    }

    public int getNumberOfTopGrades(int limitInPerCent, int ... results) {  // Megkeresi a küszöbérték felettii eredményeket
        if (results == null || results.length == 0) {               // Ha a vizsgaeredmény felsorolást nem adják meg
            throw new IllegalArgumentException("Number of results must not be empty!");     // Kivételt dob
        }

        int numberOfTop = 0;                                        // temporális változó deklarálása, 0 kezdőértékkel
        for (int point : results) {                                 // for-each ciklus az eredmények varargs tömbjén
            if (point > (1.0 * limitInPerCent / 100) * maxPoints) { // ha a minimális pontszámnál nagyobb a pontja az
                                                                            // aktuálisan vizsgált ciklusvált-nak
                numberOfTop++;                                      // temporális vált-t növeli 1-gyel
            }
        }
        return numberOfTop;                                         // visszatér a temporális változóval
    }

    public boolean hasAnyFailed(int limitInPerCent, int ... results) { // Bukott-e vki, küszöbérték alatti vizsgaeredmények
        if (results == null || results.length == 0) {
            throw new IllegalArgumentException("Number of results must not be empty!");
        }

        for (int point : results) {
            if (point < (1.0 * limitInPerCent / 100) * maxPoints) {    // ha van a min pontszámnál alacsonyabb
                return true;                                           // igen, bukott
            }
        }
        return false;
    }


}
