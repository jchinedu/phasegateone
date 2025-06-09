import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditCardValidatorTest {
@Test
    public void testIsValidLengthAndDigits() {
        assertTrue(CreditCardValidator.validLength("4539876543210124"));
        //assertFalse(CreditCardValidator.isValidLengthAndDigits("4539a76543210124")); 
}
}