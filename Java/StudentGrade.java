import java.util.Scanner;
public class StudentGrade {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
 while(true){
        System.out.print("How many students do you have: ");
        int numberOfStudents = input.nextInt(); 
	if(numberOfStudents < 0) {
	System.out.print("invalid input, try again: ");
	}
	if(numberOfStudents >= 0) {
	break;
	}
	}            
	
        System.out.print("How many subjects do they offer: ");
        int numberOfSubjects = input.nextInt();
	

        int[][] scores = new int[numberOfStudents][numberOfSubjects];

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Enter scores for Student " + (i + 1));
            for (int j = 0; j < numberOfSubjects; j++) {
                int score;
                do {
                    System.out.print("Enter score for Subject " + (j + 1) + ": ");
                    score = input.nextInt();
                    if (score < 0 || score > 100) {
                        System.out.println("Invalid score, must be between 0-100.");
                    }
                } while (score < 0 || score > 100);
                scores[i][j] = score;
                System.out.println("Saving >>>>>>>>>>>>>>>");
                System.out.println("Saved successfully");
            }
        }

        int[] totals = new int[numberOfStudents];
        double[] averages = new double[numberOfStudents];
        StudentGradefunction.calculateTotals(scores, totals);
        StudentGradefunction.calculateAverages(totals, averages, numberOfSubjects);
        int[] positions = StudentGradefunction.checkPosition(totals);

        System.out.print("Enter pass mark: ");
        int passMark = input.nextInt();

        int option;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Display Student Table");
            System.out.println("2. Display Subject Summary");
            System.out.println("3. Display Class Summary");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            option = input.nextInt();

     switch (option) {
                case 1:
                    StudentGradefunction.displayTable(scores, totals, averages, positions);
                    break;
                case 2:
                    StudentGradefunction.subjectSummary(scores, passMark);
                    break;
                case 3:
                    int[] hardest = StudentGradefunction.findHardestSubject(scores, passMark);
                    int[] easiest = StudentGradefunction.findEasiestSubject(scores, passMark);
                    System.out.printf("The Hardest Subject is Subject %d with %d failures\n", hardest[0] + 1, hardest[1]);
                    System.out.printf("The Easiest Subject is Subject %d with %d passes\n", easiest[0] + 1, easiest[1]);
                    System.out.println("===========================================================");
                    break;
                case 0:
                    System.out.println("Exiting..");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
       }

  } while (option != 0);
 }
}
