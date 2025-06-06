import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MenstrualCycleInputTest {

    @Test
    public void testIsValidDate_ValidDate() {
        assertTrue(MenstrualCycleInput.isValidDate(15, 6, 2025));
    }

    
}
