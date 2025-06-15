import org.junit.jupiter.api.Test;
import java.util.Scanner;
import java.io.ByteArrayInputStream;

public class SemiColonStoreCheckoutTest {

    @Test
    public void testGetValidIntExists() {
        String input = "42\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        int result = SemiColonStoreCheckout.getValidInt(scanner);
    }

    @Test
    public void testGetValidDoubleExists() {
        String input = "3.1415\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        double result = SemiColonStoreCheckout.getValidDouble(scanner);
    }

    @Test
    public void testPrintHeaderExists() {
        SemiColonStoreCheckout.printHeader();
    }

    @Test
    public void testHandlePaymentExists_CashPayment() {
        String input = "1\n100\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        double paid = SemiColonStoreCheckout.handlePayment(scanner, 50.0);
    }

    @Test
    public void testHandlePaymentExists_CardPayment() {
        String input = "2\n1234567890123456\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        double paid = SemiColonStoreCheckout.handlePayment(scanner, 50.0);
    }

    @Test
    public void testHandlePaymentExists_MobileMoneyPayment() {
        String input = "3\nMMREF12345\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        double paid = SemiColonStoreCheckout.handlePayment(scanner, 50.0);
    }
}
