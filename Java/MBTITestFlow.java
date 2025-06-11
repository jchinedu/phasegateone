import java.util.Scanner;

public class MBTITestFlow {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        showWelcomeMessage();
   while (true) {
            System.out.println("\nType 'start' to take the test or 'exit' to quit:");
            String input = scanner.nextLine().trim().toLowerCase();
	   if (input.equals("start")) {
                String gender = promptGender();
                if (gender == null) continue;
	while (true) {
                    System.out.println("\nChoose an option:");
                    System.out.println("1 - Take the test");
                    System.out.println("2 - Learn about personality traits");
                    System.out.println("0 - Go back");  
	 String choice = scanner.nextLine().trim();