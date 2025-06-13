import java.util.Scanner;
public class StudentGrade {
 public static void main(String[] args){
	Scanner input = new Scanner(System.in);
	System.out.print("how many students do you have: "); 
	int NumberOfStudents = input.nextInt();

	System.out.print("how many subjects do they offer: ");
	int NumberOfSubjects = input.nextInt();

	int[][] scores = new int[NumberOfStudents][NumberOfSubjects];

	for(int i = 0; i < NumberOfStudents; i++){
		System.out.println("Enter score of student " + (i+1));
	for(int j = 0; j < NumberOfSubjects; j++){
		int score;
	   do{
		System.out.println("Enter score for subject " + (j +1));
		 score = input.nextInt();
		if (score < 0 || score > 100){
		System.out.print("invalid score, must be between 0-100");
		}
	   }while(score < 0 || score > 100);
		scores[i][j] = score;
		System.out.println("saving >>>>>>>>>>>>>>>");
		System.out.println("saved successfully");
	}
	}
		int[] totals = new int[NumberOfStudents];
        double[] averages = new double[NumberOfStudents];
 
        StudentGradefunction.calculateTotalsAndAverages(scores, totals, averages);
        int[] positions = StudentGradefunction.checkPosition(totals);
        StudentGradefunction.displayTable(scores, totals, averages, positions);

	}
}

		

	