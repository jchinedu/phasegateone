import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class SemiColonStoreCheckout {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Welcome to SemiColon Stores Checkout System!");
	
	System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();


	ArrayList<String> productNames = new ArrayList<>();
        ArrayList<Integer> quantities = new ArrayList<>();
        ArrayList<Double> unitPrices = new ArrayList<>();

	while (true) {
		System.out.print("Enter product name (or 'done' to finish): ");
            String product = scanner.nextLine();
            if (product.equalsIgnoreCase("done")) {
                if (productNames.isEmpty()) {
                    System.out.println("No products entered. Please enter at least one product.");
                    continue;
                }
                break;
            }
	       System.out.print("Enter unit price: ");
            double price = getValidDouble(scanner);




}






































}

}