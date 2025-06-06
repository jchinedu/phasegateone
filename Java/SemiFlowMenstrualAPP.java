import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class SemiFlowMenstrualAPP {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int mainChoice;

        System.out.println("==================================");
        System.out.println("   Welcome to Semi Flow Tracker   ");
        System.out.println("==================================");

        do {
            System.out.println("\nAre you using Semi Flow for yourself?");
            System.out.println("1. Yes");
            System.out.println("2. No, I have a partner");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            while (!input.hasNextInt()) {
                System.out.print("Invalid input. Please enter 1, 2, or 0: ");
                input.next();
            }
            mainChoice = input.nextInt();

            switch (mainChoice) {
                case 1:
                    System.out.println("\nHow did you find out about Semi Flow?");
                    System.out.println("1. Semicolon Africa");
                    System.out.println("2. Personal learning");
                    System.out.println("3. Friends or family");
                    System.out.println("4. Google Play or Google Search");
                    System.out.println("5. TikTok");
                    System.out.println("6. YouTube");
                    System.out.println("7. Influencer or Celebrity");
                    System.out.println("8. Medical professional");
                    System.out.println("9. Others");

                    System.out.print("Enter your choice (1 to 9): ");
                    int source = input.nextInt();
		    input.nextLine();
                 

                    switch (source) {
                        case 1 -> System.out.println("Nice! Shoutout to Semicolon Africa.");
                        case 2 -> System.out.println("Learning is power!");
                        case 3 -> System.out.println("We're happy your circle shared us!");
                        case 4 -> System.out.println("Glad you searched and found us!");
                        case 5 -> System.out.println("TikTok knows everything!");
                        case 6 -> System.out.println("Thanks for watching and joining.");
                        case 7 -> System.out.println("Shoutout to the influencers out there!");
                        case 8 -> System.out.println("Great to know professionals recommend us.");
                        case 9 -> System.out.println("Thank you for discovering Semi Flow.");
                        default -> System.out.println("Thanks for joining us!");
                    }

                   
                    System.out.print("\nWhen were you born? (Enter as YYYY-MM-DD): ");
                    String dobInput = input.nextLine();
                    LocalDate dob;
                    try {
                        dob = LocalDate.parse(dobInput);
                        LocalDate today = LocalDate.now();
                        int age = Period.between(dob, today).getYears();

                        if (age < 13) {
                            System.out.println("Sorry, Semi Flow is for users aged 13 and above.");
                            break;
                        }

                       
                        System.out.println("\nWelcome to Semi Flow!");
                        System.out.println("Are you pregnant?");
                        System.out.println("1. No, but I want to be");
                        System.out.println("2. No, I am here to understand my body better");
                        System.out.println("3. Yes, I am");

                        System.out.print("Enter your choice: ");
                        int pregnancyChoice = input.nextInt();
			input.nextLine();
                     

                        switch (pregnancyChoice) {
                            case 1 -> System.out.println("We’re here to support your journey.");
                            case 2 -> {
                                System.out.println("Awesome! Lets help you understand your body better.");
				MenstrualCycleInput.getMenstrualCycleInput(input);
                                
                            }
                            case 3 -> System.out.println("Congratulations! Pregnancy support features coming soon.");
                            default -> System.out.println("Thanks for sharing!");
                        }

                    } catch (Exception e) {
                        System.out.println("Invalid date format. Please use YYYY-MM-DD.");
                    }

                    break;

                case 2:
                    System.out.println("Partner tracking isn’t available yet. Press 0 to return to the main menu.");
                    break;

                case 0:
                    System.out.println("Thank you for using Semi Flow. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 0.");
            }

        } while (mainChoice != 0);
    }
  }
