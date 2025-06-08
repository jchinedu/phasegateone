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


		productNames.add(product);
            quantities.add(qty);
            unitPrices.add(price);
        }
	
		System.out.print("Enter cashier name: ");
        String cashierName = scanner.nextLine();

		System.out.print("Is there any discount for this customer? (yes/no): ");
        String discountResponse = scanner.nextLine();
        double discountPercent = 0.0;
        if (discountResponse.equalsIgnoreCase("yes")) {
            System.out.print("Enter discount percentage: ");
            discountPercent = getValidDouble(scanner);
            if (discountPercent < 0) discountPercent = 0;
            if (discountPercent > 100) discountPercent = 100;
        }

		double subtotal = 0.0;
        for (int i = 0; i < productNames.size(); i++) {
            subtotal += quantities.get(i) * unitPrices.get(i);
        }


		double discountAmount = subtotal * discountPercent / 100.0;
        double totalAfterDiscount = subtotal - discountAmount;
        double vat = totalAfterDiscount * 0.075;
        double totalDue = totalAfterDiscount + vat;



		printHeader();
        System.out.println("Customer: " + customerName);
        System.out.println("Cashier: " + cashierName);
        System.out.println("--------------------------------------");
        System.out.printf("%-15s %5s %10s %12s%n", "Product", "Qty", "Unit Price", "Total Price");
        System.out.println("--------------------------------------");



















}

}