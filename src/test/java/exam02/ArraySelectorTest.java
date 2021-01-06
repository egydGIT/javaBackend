package exam02;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArraySelectorTest {

        @Test
        public void selectEvens() {
            //assertEquals("", new ArraySelector().selectEvens(new int[]{}));
            assertEquals("[1]", new ArraySelector().selectEvens(new int[]{1}));
            assertEquals("[1]", new ArraySelector().selectEvens(new int[]{1, 2}));
            assertEquals("[1, 3]", new ArraySelector().selectEvens(new int[]{1, 2, 3}));
            assertEquals("[1, 3]", new ArraySelector().selectEvens(new int[]{1, 2, 3, 4}));
            assertEquals("[1, 3, 5]", new ArraySelector().selectEvens(new int[]{1, 2, 3, 4, 5}));
        }

        @Test
        void testSelectEvens() {
            ArraySelector arraySelector = new ArraySelector();
            int [] array = { 1, 2, 3, 4, 5};
            assertEquals(Arrays.asList(1, 3, 5).toString(), arraySelector.selectEvens(array));
            assertEquals("[1, 3, 5]", arraySelector.selectEvens(array));
        }

}





