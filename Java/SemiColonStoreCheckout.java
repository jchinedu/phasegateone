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
        break;
    }

    System.out.print("Enter unit price: ");
    while (!scanner.hasNextDouble()) {
        System.out.print("Invalid input. Enter a valid number: ");
        scanner.next();
    }
    double price = scanner.nextDouble();

    System.out.print("Enter quantity purchased: ");
    while (!scanner.hasNextInt()) {
        System.out.print("Invalid input. Enter a valid integer: ");
        scanner.next();
    }
    int qty = scanner.nextInt();
    scanner.nextLine(); 

    productNames.add(product);
    unitPrices.add(price);
    quantities.add(qty);
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
        System.out.println("=================================================");
        System.out.printf("%-15s %5s %10s %12s%n", "ITEM", "QTY", "PRICE", "TOTAL(NGN)");
        System.out.println("-------------------------------------------------");



		for (int i = 0; i < productNames.size(); i++) {
            double lineTotal = quantities.get(i) * unitPrices.get(i);
            System.out.printf("%-15s %5d %10.2f %12.2f%n", productNames.get(i), quantities.get(i), unitPrices.get(i), lineTotal);
        }
        System.out.println("-------------------------------------------------");
        System.out.printf("Subtotal: %35.2f%n", subtotal);
        System.out.printf("Discount (%.2f%%): %27.2f%n", discountPercent, discountAmount);
        System.out.printf("VAT  @ 7.5%% : %31.2f%n", vat);
        System.out.println("-------------------------------------------------");
        System.out.printf("TOTAL DUE: %35.2f%n", totalDue);
        System.out.println();
	System.out.println("=====================================================");
        System.out.println("THIS IS NOT A RECEIPT, KINDLY PAY THIS AMOUNT: " + String.format("%.2f", totalDue));
	System.out.println("=====================================================");
        System.out.println();

		 double amountPaid = handlePayment(scanner, totalDue);

		 printHeader();
        System.out.println("RECEIPT - SEMICOLON STORES");
        System.out.println("Customer: " + customerName);
        System.out.println("Cashier: " + cashierName);
        System.out.println("----------------------------------------------");
        System.out.printf("%-15s %5s %10s %12s%n", "ITEM", "QTY", "PRICE", "TOTAL");
        System.out.println("----------------------------------------------");

        for (int i = 0; i < productNames.size(); i++) {
            double lineTotal = quantities.get(i) * unitPrices.get(i);
            System.out.printf("%-15s %5d %10.2f %12.2f%n", productNames.get(i), quantities.get(i), unitPrices.get(i), lineTotal);
        }
		 System.out.println("----------------------------------------------");
        System.out.printf("Subtotal: %35.2f%n", subtotal);
        System.out.printf("Discount (%.2f%%): %27.2f%n", discountPercent, discountAmount);
        System.out.printf("VAT @ 7.5%%: %33.2f%n", vat);
        System.out.println("----------------------------------------------");
        System.out.printf("TOTAL PAID: %34.2f%n", amountPaid);
        System.out.printf("CHANGE: %38.2f%n", amountPaid - totalDue);
        System.out.println();
        System.out.println("THANK YOU FOR SHOPPING WITH SEMICOLON STORES!");
        System.out.println("Visit us again!");
	
	}
    
	public static int getValidInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter a valid integer: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
	public static double getValidDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Enter a valid number: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }
	public static void printHeader() {
        System.out.println("====================================================");
        System.out.println("SEMICOLON STORES            ");
	System.out.println("MAIN BRANCH            ");
        System.out.println("LOCATION: 312, HERBERT MACAULY WAY, SABO YABA, LAGOS.    ");
        System.out.println("Tel: +123 456 7890             ");
        System.out.println("Date: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
           }
	public  static double handlePayment(Scanner scanner, double totalDue) {
        System.out.println("Select payment method:");
        System.out.println("1. Cash");
        System.out.println("2. Card");
        System.out.println("3. Mobile Money");
        System.out.print("Enter your choice: ");
        int paymentChoice = getValidInt(scanner);
        scanner.nextLine();
	
	switch (paymentChoice) {
            case 1:
                System.out.print("Enter amount paid by customer: ");
                double amountPaid = getValidDouble(scanner);
                scanner.nextLine();
                if (amountPaid < totalDue) {
                    System.out.println("Insufficient payment. Please pay at least: " + String.format("%.2f", totalDue));
                    return handlePayment(scanner, totalDue);
                } else {
                    double change = amountPaid - totalDue;
                    System.out.println("Change to give back: " + String.format("%.2f", change));
                    return amountPaid;
                }
            case 2:
                System.out.print("Enter card number (simulate): ");
                String cardNumber = scanner.nextLine();
                System.out.println("Payment of " + String.format("%.2f", totalDue) + " processed via card ending with "
                        + cardNumber.substring(Math.max(0, cardNumber.length() - 4)));
                return totalDue;
            case 3:
                System.out.print("Enter mobile money reference: ");
                String mmRef = scanner.nextLine();
                System.out.println("Payment of " + String.format("%.2f", totalDue) + " processed with reference " + mmRef);
                return totalDue;
            default:
                System.out.println("Invalid payment method. Please try again.");
                return handlePayment(scanner, totalDue);
        }
}

}