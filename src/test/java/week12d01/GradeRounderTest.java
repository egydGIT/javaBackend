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

    @Test
    void gradesRoundGradesArray() {
        int [] grades = new GradeRounder().fillGrades();
        int [] roundedGrade = new GradeRounder().gradesRoundGradesArray(grades);
        assertEquals(0, roundedGrade[0]);
        assertEquals(40, roundedGrade[39]);
        assertEquals(45, roundedGrade[42]);
        assertEquals(50, roundedGrade[46]);
        //assertEquals(50, roundedGrade[51]);                        // 52-t 50-ra kellene
    }

//    @Test
//    void gradesRoundGradesMath() {
//        int [] grades = new GradeRounder().fillGrades();
//        int [] roundedGradeMath = new GradeRounder().gradesRoundGradesMath(grades);
//        assertEquals(0, roundedGradeMath[0]);
//        assertEquals(0, roundedGradeMath[39]);
//        assertEquals(45, roundedGradeMath[42]);
//        assertEquals(50, roundedGradeMath[46]);
//        assertEquals(50, roundedGradeMath[51]);                        // 52-t 50-ra kellene
//    }

}