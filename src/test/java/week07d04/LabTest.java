package week07d04;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LabTest {

    @Test
    void testCreate() {
        Lab lab = new Lab(Title.DO_EXCERCISES);
        assertEquals(false, lab.isCompleted());
    }

    @Test
    void testCompleteNow() {
        Lab lab = new Lab(Title.DO_EXCERCISES);
        lab.complete();
        assertEquals(true, lab.isCompleted());
    }

    @Test
    void testCompleteWhen() {
        Lab lab = new Lab(Title.TAKE_NOTES);
        lab.complete(2020, 12, 23);
        assertEquals(true, lab.isCompleted());
        assertEquals(LocalDate.of(2020,12,23), lab.getCompletedAt());
    }
}
