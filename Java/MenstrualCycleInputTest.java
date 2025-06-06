import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MenstrualCycleInputTest {

    @Test
    public void testIsValidDate_ValidDate() {
        assertTrue(MenstrualCycleInput.isValidDate(15, 6, 2025));
    }
    
   @Test
    public void testIsValidDate_InvalidDate() {
        assertFalse(MenstrualCycleInput.isValidDate(31, 2, 2025));
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
    public void testAddToDays_YearRollover() {
        int[] result = MenstrualCycleInput.addToDays(30, 12, 2025, 5);
        assertEquals(4, result[0]);
        assertEquals(1, result[1]);
        assertEquals(2026, result[2]);
}

    
}
