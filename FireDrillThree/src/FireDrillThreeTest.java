import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
public class FireDrillThreeTest {

    @Test
    public void testThat_taskFour_FunctionsProperly() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] actual = FireDrillThree.taskFour(arr);
        int[] expected = new int[]{1, 0, 3, 0, 5, 0, 7, 0, 9, 0};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void testThat_taskFive_FunctionsProperly() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] actual = FireDrillThree.taskFive(arr);
        int[] expected = new int[]{0, 2, 0, 4, 0, 6, 0, 8, 0, 10};
        assertArrayEquals(expected, actual);
    }
}
    @Test
    public void testThat_taskSix_FunctionsProperly() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int []actual = FireDrillThree.taskFour(arr);
        assertArrayEquals(25, actual);
        int expected = 24;
        assertEquals(expected, actual);
    }
    @Test
    public void testThat_taskSeven_FunctionsProperly() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int []actual = FireDrillThree.taskFive(arr);
        int expected = FireDrillThree.taskSix(actual);
        assertEquals(expected, actual);
    }
}

//    @org.junit.jupiter.api.Test
//    void taskFive() {
//    }
//
//    @org.junit.jupiter.api.Test
//    void taskSix() {
//    }
//
//    @org.junit.jupiter.api.Test
//    void taskSeven() {
//    }
//}