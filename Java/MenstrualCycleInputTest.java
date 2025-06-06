import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MenstrualCycleInputTest {

    @Test
    public void testIsValidDate_ValidDate() {
        assertTrue(MenstrualCycleInput.isValidDate(15, 6, 2025));
    }

    @Test
    public void testIsValidDate_InvalidDate() {
        assertFalse(MenstrualCycleInput.isValidDate(31, 2, 2025));  // Feb 31 invalid
    }

    @Test
    public void testPrintLeapYear_LeapYear() {
        assertTrue(MenstrualCycleInput.printLeapYear(2024));
        assertTrue(MenstrualCycleInput.printLeapYear(2000));
    }

    @Test
    public void testPrintLeapYear_NonLeapYear() {
        assertFalse(MenstrualCycleInput.printLeapYear(2023));
        assertFalse(MenstrualCycleInput.printLeapYear(1900));
    }

    @Test
    public void testAddToDays_SimpleAddition() {
        int[] result = MenstrualCycleInput.addToDays(10, 6, 2025, 5);
        assertEquals(15, result[0]);
        assertEquals(6, result[1]);
        assertEquals(2025, result[2]);
    }

    @Test
    public void testAddToDays_MonthRollover() {
        int[] result = MenstrualCycleInput.addToDays(28, 2, 2024, 3);  // Leap year
        assertEquals(2, result[0]);   // March 2
        assertEquals(3, result[1]);
        assertEquals(2024, result[2]);
    }

    @Test
    public void testAddToDays_YearRollover() {
        int[] result = MenstrualCycleInput.addToDays(30, 12, 2025, 5);
        assertEquals(4, result[0]);
        assertEquals(1, result[1]);
        assertEquals(2026, result[2]);
    }
}
