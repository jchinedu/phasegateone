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
@Test
    public void testCalculateAverages() {
        int[] totals = {240, 220, 285};
        double[] averages = new double[totals.length];
        StudentGradefunction.calculateAverages(totals, averages, 3);

        assertArrayEquals(new double[]{80.0, 73.33, 95.0}, averages, 0.01);
    }
 @Test
    public void testCheckPosition() {
        int[] totals = {240, 220, 285}; 
        int[] expectedRanks = {2, 3, 1};
        int[] positions = StudentGradefunction.checkPosition(totals);

        assertArrayEquals(expectedRanks, positions);
    }
@Test
    public void testDisplayTableOutput() {
    }
}
