import java.util.Scanner;

public class MBTITestFlow {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
    showWelcomeMessage();

    while (true) {
        System.out.println("\nPlease choose an option:");
        System.out.println("1. Start the test");
        System.out.println("2. Exit");
        System.out.print("Enter 1 or 2: ");

        String input = scanner.nextLine().trim();

        if (input.equals("1")) {
            String gender = promptGender();
            if (gender == null) {
                continue;
            }

            
            while (true) {
                System.out.println("\nChoose an option:");
                System.out.println("1 - Take the test");
                System.out.println("2 - Learn about personality traits");
                System.out.println("0 - Go back");

                String choice = scanner.nextLine();

                switch (choice) {
                    case "1" -> {
                        System.out.println("\nGreat! Starting the test...");
                        runMBTITest();
                        return;
                    }
                    case "2" -> showPersonalityTraitsInfo();
                    case "0" -> {
                        System.out.println("Going back to main menu...");
                        break; 
                    }
                    default -> System.out.println("Invalid choice, try again.");
                }

                if (choice.equals("0")) break;
            }

        } else if (input.equals("2")) {
            System.out.println("Thanks for stopping by. Goodbye!");
            break; 
        } else {
            System.out.println("Invalid command. Please enter 1 or 2.");
        }
    }
}

		static void showWelcomeMessage() {
        System.out.println("Its so incredible to finally be understood, ");
        System.out.println("Only 10 minutes to get a freakishly accurate description of who you are and why you do things the way you do.");
    }

    static String promptGender() {
    System.out.println("\nPlease select your gender:");
    System.out.println("1. Male");
    System.out.println("2. Female");
    System.out.print("Enter 1 or 2: ");

    String input = scanner.nextLine().trim();

    switch (input) {
        case "1":
            System.out.println("You selected: Male");
            return "male";
        case "2":
            System.out.println("You selected: Female");
            return "female";
        default:
            System.out.println("Invalid input. Please enter 1 or 2.");
            return null;
    }
}

	static void showPersonalityTraitsInfo() {
    System.out.println("\nWhat Does the MBTI Personality Test Measure");
    System.out.println("The MBTI test helps you discover how you think, feel, and behave by placing you into one of 16 personality types.");
    System.out.println("These types are made up of 4 letters, each chosen from a pair of opposites:");

    System.out.println("\n1. Extraversion (E) vs Introversion (I)");
    System.out.println("E (Extraversion): You gain energy from being around others. You enjoy social interaction.");
    System.out.println("I (Introversion): You gain energy from being alone. You prefer deeper, one-on-one connections.");

    System.out.println("\n2. Sensing (S) vs Intuition (N)");
    System.out.println("S (Sensing): You focus on facts, details, and the present moment.");
    System.out.println("N (Intuition): You focus on ideas, possibilities, and future potential.");

    System.out.println("\n3. Thinking (T) vs Feeling (F)");
    System.out.println("T (Thinking): You make decisions based on logic, objectivity, and fairness.");
    System.out.println("F (Feeling): You make decisions based on personal values, emotions, and empathy.");

    System.out.println("\n4. Judging (J) vs Perceiving (P)");
    System.out.println("J (Judging): You prefer structure, planning, and clear organization.");
    System.out.println("P (Perceiving): You prefer flexibility, spontaneity, and keeping your options open.");

    System.out.println("\nExample Personality Type: INFP");
    System.out.println("I: Introverted: enjoys solitude and reflection");
    System.out.println("N: Intuitive: future focused and imaginative");
    System.out.println("F: Feeling: guided by values and empathy");
    System.out.println("P: Perceiving: open to change and adaptable");

    System.out.println("\nWhy it matters:");
    System.out.println("Understanding your MBTI type can help you:");
    System.out.println("Improve relationships by understanding others better.");
    System.out.println("Choose careers that suit your strengths.");
    System.out.println("Grow in self awareness and decision making.");

    System.out.println("\nThere are 16 possible types like ENFP, ISTJ, or INFJ each offering a different lens into your personality.");
}

	static void runMBTITest() {
        StringBuilder answers = new StringBuilder();

  
        for (int i = 0; i < MBTITest.questions.length; i++) {
            String[] question = MBTITest.questions[i];
            System.out.println("\nQuestion " + (i + 1) + ":");
            System.out.println("A. " + question[0]);
            System.out.println("B. " + question[1]);
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
            String personalityType = MBTITest.processAnswers(answers.toString());
            System.out.println("\nYour MBTI personality type is: " + personalityType);
            MBTITest.displayPersonalityDescription(personalityType);
        } catch (IllegalArgumentException e) {
            System.out.println("Error processing test: " + e.getMessage());
        }
    }

    }