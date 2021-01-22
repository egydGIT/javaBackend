package enumabstract;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderStateTest {

    @Test
    void testCanDeleteNew() {

        OrderState os = OrderState.NEW;

        assertTrue(os.canDelete());
    }

    @Test
    void testCanDeleteOnboard() {

        OrderState os = OrderState.ONBOARD;

        assertFalse(os.canDelete());
    }
}