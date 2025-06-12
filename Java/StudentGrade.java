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
		System.out.print("saving >>>>>>>>>>>>>>>");
		System.out.print("saved successfully");
	for(int j = 0; j < NumberOfSubjects; j++){
		System.out.println("Enter score for subject " + (i +1));
		System.out.print("saving >>>>>>>>>>>>>>>");
		System.out.print("saved successfully");

		do {
			System.out.print("

	