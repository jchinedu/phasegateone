import java.util.Scanner;
import java.time.LocalDate;
import java.time.DateTimeException;

public class MenstrualCycleInput {

    public static void getMenstrualCycleInput(Scanner input) {
        while (true) {
            System.out.print("What is your name? ");
            String name = input.nextLine();

            System.out.print("Enter the first day of your last menstrual cycle (from day 1 to day 31 monthly as the case may be): ");
            int recentMenstrualDate = input.nextInt();

            System.out.print("Enter the month of your last menstrual cycle (from january beign 1 to december being 12): ");
            int lastMenstrualMonth = input.nextInt();

            System.out.print("Enter the year of your last menstrual cycle: ");
            int lastMenstrualYear = input.nextInt();

	    input.nextLine();

            if (!isValidDate(recentMenstrualDate, lastMenstrualMonth, lastMenstrualYear)) {
                System.out.println("Invalid date, Kindly enter the correct date");
            } else {
                System.out.printf("Hello %s, your last menstrual cycle started on %02d-%02d-%d.\n",
                        name, recentMenstrualDate, lastMenstrualMonth, lastMenstrualYear);
                break;
            }
        }
    }

    public static boolean isValidDate(int day, int month, int year) {
        try {
            LocalDate.of(year, month, day);
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }
}
