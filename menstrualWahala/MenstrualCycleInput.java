import java.time.LocalDate;
import java.time.DateTimeException;
import java.util.Scanner;

public class MenstrualCycleInput {

    public static void getMenstrualCycleInput(Scanner input) {
        while (true) {
            System.out.print("What is your name? ");
            String name = input.nextLine();

            System.out.print("Enter the first day of your last menstrual cycle(1-31): ");
            int recentMenstrualDate = input.nextInt();

            System.out.print("Enter the month of your last menstrual cycle(1-12): ");
            int lastMenstrualMonth = input.nextInt();

            System.out.print("Enter the year of your last menstrual cycle: ");
            int lastMenstrualYear = input.nextInt();

            input.nextLine();

            if (!isValidDate(recentMenstrualDate, lastMenstrualMonth, lastMenstrualYear)) {
                System.out.println("Invalid date, kindly enter the correct date");
            } else {
                System.out.printf("Hello %s, your last menstrual cycle started on %02d-%02d-%d.\n\n",
                        name, recentMenstrualDate, lastMenstrualMonth, lastMenstrualYear);

                printPeriodFlowDates(recentMenstrualDate, lastMenstrualMonth, lastMenstrualYear);

                printOvulationPeriod(recentMenstrualDate, lastMenstrualMonth, lastMenstrualYear);

                printNextPeriodDate(recentMenstrualDate, lastMenstrualMonth, lastMenstrualYear);

                printSafePeriod(recentMenstrualDate, lastMenstrualMonth, lastMenstrualYear);

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

    public static int[] addToDays(int date, int month, int year, int daysToAdd) {
        int[] totalDaysInAMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (printLeapYear(year)) {
            totalDaysInAMonth[1] = 29;
        }

        for (int i = 0; i < daysToAdd; i++) {
            date++;
            if (date > totalDaysInAMonth[month - 1]) {
                date = 1;
                month++;

                if (month > 12) {
                    month = 1;
                    year++;
                    if (printLeapYear(year)) {
                        totalDaysInAMonth[1] = 29;
                    } else {
                        totalDaysInAMonth[1] = 28;
                    }
                }
            }
        }
        return new int[]{date, month, year};
    }

    public static boolean printLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void printPeriodFlowDates(int recentMenstrualDate, int lastMenstrualMonth, int lastMenstrualYear) {
        System.out.println("Your Period flow dates (5 Days)");
        int currentDate = recentMenstrualDate;
        int currentMonth = lastMenstrualMonth;
        int currentYear = lastMenstrualYear;

        for (int number = 0; number < 5; number++) {
            System.out.printf("Day %d: %02d-%02d-%d\n", (number + 1), currentDate, currentMonth, currentYear);

            int[] nextDate = addToDays(currentDate, currentMonth, currentYear, 1);
            currentDate = nextDate[0];
            currentMonth = nextDate[1];
            currentYear = nextDate[2];
        }
        System.out.println();
    }

    public static void printOvulationPeriod(int recentMenstrualDate, int lastMenstrualMonth, int lastMenstrualYear) {
        int[] ovulationStart = addToDays(recentMenstrualDate, lastMenstrualMonth, lastMenstrualYear, 12);
        int[] ovulationEnd = addToDays(recentMenstrualDate, lastMenstrualMonth, lastMenstrualYear, 16);

        System.out.println("Ovulation Period:");
        System.out.printf("Start: %02d-%02d-%d\n", ovulationStart[0], ovulationStart[1], ovulationStart[2]);
        System.out.printf("End:   %02d-%02d-%d\n\n", ovulationEnd[0], ovulationEnd[1], ovulationEnd[2]);
    }

    public static void printNextPeriodDate(int recentMenstrualDate, int lastMenstrualMonth, int lastMenstrualYear) {
        int[] nextPeriod = addToDays(recentMenstrualDate, lastMenstrualMonth, lastMenstrualYear, 28 + (int) (Math.random() * 3));
        System.out.println("Your Next Period Prediction:");
        System.out.printf("Predicted Date: %02d-%02d-%d\n\n", nextPeriod[0], nextPeriod[1], nextPeriod[2]);
    }

    public static void printSafePeriod(int startDay, int startMonth, int startYear) {
        System.out.println("Safe Period Dates:");

        int[] safeStartBefore = addToDays(startDay, startMonth, startYear, 0);
        int[] safeEndBefore = addToDays(startDay, startMonth, startYear, 11);

        int[] safeStartAfter = addToDays(startDay, startMonth, startYear, 17);
        int[] safeEndAfter = addToDays(startDay, startMonth, startYear, 28);

        System.out.println("Safe Period Before Fertile Window: "
                + String.format("%02d-%02d-%d", safeStartBefore[0], safeStartBefore[1], safeStartBefore[2])
                + " to "
                + String.format("%02d-%02d-%d", safeEndBefore[0], safeEndBefore[1], safeEndBefore[2]));

        System.out.println("Safe Period After Fertile Window: "
                + String.format("%02d-%02d-%d", safeStartAfter[0], safeStartAfter[1], safeStartAfter[2])
                + " to "
                + String.format("%02d-%02d-%d", safeEndAfter[0], safeEndAfter[1], safeEndAfter[2]));

        System.out.println("\nNote: Safe period refers to the days with a lower chance of pregnancy.");
        System.out.println();
    }
}
