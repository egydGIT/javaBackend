package introjunit;

import algorithmsmax.trainer.Trainer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GentlemanTest {

    @Test
    public void testCreate() {
        // Given
        Gentleman gentleman = new Gentleman("John Doe");
        // When
        String sayHello = gentleman.sayHello();
        // Than
        assertEquals ("Hello John Doe", sayHello);
    }

    /*  Wrong:

    @Test
    public void testCreateWrong() {
        // Given
        Gentleman gentleman = new Gentleman("John Doe");
        // When
        String sayHello = gentleman.sayHello();
        // Than
        assertEquals ("Hello John Doe!", sayHello);             //      Expected :Hello John Doe!
                                                                //      Actual   :Hello John Doe
    }

     */

    @Test
    public void testCreateBriefly() {
        assertEquals("Hello John Doe", new Gentleman("John Doe").sayHello());
    }

    @Test
    public  void testCreateNull() {
        assertEquals("Hello Anonymus", new Gentleman(null).sayHello());
    }

    @Test
    public void testCreateWholeCoverage() {
        assertEquals("John Doe", new Gentleman("John Doe").getName());
    }


    // Solution
    @Test
    public void byNormalName() {
        // Given
        String name = "John Doe";

        // When
        String greeting = new Gentleman(name).sayHello();

        // Then
        assertEquals("Hello John Doe", greeting);
    }
}
