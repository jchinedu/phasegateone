import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditCardValidatorTest {
@Test
    public void testIsValidLengthAndDigits() {
        assertTrue(CreditCardValidator.validLength("4539876543210124"));
        assertFalse(CreditCardValidator.validLength("12345")); 
}

@Test
    public void cardType() {
        assertEquals("VISA", CreditCardValidator.cardType("4539876543210124"));
}
}