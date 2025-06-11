import java.util.Scanner;

public class MBTITestFlow {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        showWelcomeMessage();
   while (true) {
            System.out.println("\nType 'start' to take the test or 'exit' to quit:");
            String input = scanner.nextLine().trim().toLowerCase();
