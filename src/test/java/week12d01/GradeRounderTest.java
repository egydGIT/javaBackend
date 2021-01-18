package week12d01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GradeRounderTest {


    @Test
    void fillGrades() {
        assertEquals(100, new GradeRounder().fillGrades().length);
    }

    @Test
    void gradesRoundGrades() {

        int[] grades = new GradeRounder().fillGrades();
        assertEquals(85, new GradeRounder().gradesRoundGrades(grades, 85));
        assertEquals(85, new GradeRounder().gradesRoundGrades(grades, 83));
        assertEquals(80, new GradeRounder().gradesRoundGrades(grades, 82));
    }

}