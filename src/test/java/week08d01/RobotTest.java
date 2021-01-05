package week08d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RobotTest {

    @Test
    void testMoveOneStep() {
        Robot robot = new Robot();
        robot.moveOneStep('f');
        robot.moveOneStep('L');
        assertEquals(0, robot.getPosition().getY());
    }

    @Test
    void testMove() {
        Robot robot = new Robot();
        robot.move("jjbbffll");
        robot.move("JJBBFFLL");
        assertEquals(0, robot.getPosition().getY());
        assertEquals(0, robot.getPosition().getX());
    }

    @Test
    void testIae() {
        Robot robot = new Robot();
        assertThrows(IllegalArgumentException.class, () -> robot.moveOneStep('c'));
    }


}
