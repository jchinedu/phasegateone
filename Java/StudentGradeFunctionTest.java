import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentGradeFunctionTest {
 @Test
    public void testCalculateTotals() {
        int[][] scores = {
            {80, 90, 70},
            {60, 75, 85},
            {90, 95, 100}
        };
        int[] totals = new int[scores.length];
        StudentGradefunction.calculateTotals(scores, totals);

        assertArrayEquals(new int[]{240, 220, 285}, totals);
}
}
