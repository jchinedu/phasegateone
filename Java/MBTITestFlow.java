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

		switch (choice) {
                        case "1" -> {
                            System.out.println("\nGreat! Starting the test...");
                            runMBTITest();
                            return;                         }
                        case "2" -> showPersonalityTraitsInfo();
                        case "0" -> {
                            System.out.println("Going back to main menu...");
                            break; 
                        }
                        default -> System.out.println("Invalid choice, try again.");
                    }
		if (choice.equals("0")) break;
                }
            } else if (input.equals("exit")) {
                System.out.println("Thanks for stopping by. Goodbye!");
                break;
            } else {
                System.out.println("Invalid command. Please type 'start' or 'exit'.");
            }
        }
    }
		static void showWelcomeMessage() {
        System.out.println("“It’s so incredible to finally be understood.”");
        System.out.println("Only 10 minutes to get a “freakishly accurate” description of who you are and why you do things the way you do.");
    }

    static String promptGender() {
        System.out.println("\nPlease select your gender (Male/Female):");
        String genderInput = scanner.nextLine().trim().toLowerCase();
        if (genderInput.equals("male") || genderInput.equals("female")) {
            System.out.println("You selected: " + capitalize(genderInput));
            return genderInput;
        } else {
            System.out.println("Invalid input. Please type 'Male' or 'Female'.");
            return null;
        }
    }
	static void showPersonalityTraitsInfo() {
        System.out.println("\nPersonality traits describe how you typically think, feel, and behave.");
        System.out.println("The MBTI test sorts you into one of 16 personality types based on 4 dichotomies:");
        System.out.println("- Extraversion (E) vs Introversion (I)");
        System.out.println("- Sensing (S) vs Intuition (N)");
        System.out.println("- Thinking (T) vs Feeling (F)");
        System.out.println("- Judging (J) vs Perceiving (P)");
        System.out.println("This helps you understand yourself better and improve your relationships, career, and life choices.");
    }
	static void runMBTITest() {
        StringBuilder answers = new StringBuilder();

  
        for (int i = 0; i < MBTITest.questions.length; i++) {
            String[] q = MBTITestNoScanner.questions[i];
            System.out.println("\nQuestion " + (i + 1) + ":");
            System.out.println("A. " + q[0]);
            System.out.println("B. " + q[1]);
            String answer;
            while (true) {
                System.out.print("Choose A or B: ");
                answer = scanner.nextLine().trim().toUpperCase();
                if (answer.equals("A") || answer.equals("B")) {
                    answers.append(answer);
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 'A' or 'B'.");
                }
            }
        }
        try {
            String personalityType = MBTITestNoScanner.processAnswers(answers.toString());
            System.out.println("\nYour MBTI personality type is: " + personalityType);
            MBTITestNoScanner.displayPersonalityDescription(personalityType);
        } catch (IllegalArgumentException e) {
            System.out.println("Error processing test: " + e.getMessage());
        }
    }

    static String capitalize(String s) {
        if (s == null || s.isEmpty()) return s;
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }
}