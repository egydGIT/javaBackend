package exam03retake01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CdvCheckTest {

    @Test
    void check() {
        assertTrue(new CdvCheck().check("8365670003"));
        assertFalse(new CdvCheck().check("8365670004"));
    }

    @Test
    void checkMy() {
        assertTrue(new CdvCheck().checkMy("8365670003"));
        assertFalse(new CdvCheck().checkMy("8365670004"));
    }

    @Test
    void notNumber() {
        assertThrows(IllegalArgumentException.class,
                () -> new CdvCheck().check("993456789"));

        assertThrows(IllegalArgumentException.class,
                () -> new CdvCheck().check("99345a7890"));
    }
}