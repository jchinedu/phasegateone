public class StudentGradefunction {
    public static void calculateTotalsAndAverages(int[][] scores, int[] totals, double[] averages) {
        int numberOfStudents = scores.length;
        int numberOfSubjects = scores[0].length;

        for (int i = 0; i < numberOfStudents; i++) {
            int total = 0;
            for (int j = 0; j < numberOfSubjects; j++) {
                total += scores[i][j];
            }
            totals[i] = total;
            averages[i] = (double) total / numberOfSubjects;
        }
    }

     public static int[] checkPosition(int[] totals) {
        int[] ranks = new int[totals.length];
        for (int i = 0; i < totals.length; i++) {
            int rank = 1;
            for (int j = 0; j < totals.length; j++) {
                if (totals[j] > totals[i]) {
                    rank++;
                }
            }
            ranks[i] = rank;
        }
        return ranks;
    }


    public static void displayTable(int[][] scores, int[] totals, double[] averages, int[] positions) {
        int numberOfStudents = scores.length;
        int numberOfSubjects = scores[0].length;
	for(int index = 0; index <= (39 + (numberOfSubjects* 2)) ; index++){
		System.out.print("=");
	}
        System.out.print("\nStudent\t");
        for (int j = 0; j < numberOfSubjects; j++) {
            System.out.print("Sub" + (j + 1) + "\t");
        }
        System.out.println("Total\tAverage\tPosition");
	for(int index = 0; index <= (39 + (numberOfSubjects* 2)) ; index++){
		System.out.print("=");
	}

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.print((i + 1) + "\t"); 
            for (int j = 0; j < numberOfSubjects; j++) {
                System.out.print(scores[i][j] + "\t");
            }
            System.out.printf("\n%d\t%.2f\t%d\n", totals[i], averages[i], positions[i]);
        }
	for(int k = 0; k < 2; k++){
	 for(int i = 0; i <(39 + (numberOfSubjects* 2)); i++){
		System.out.print("=");
    }
	System.out.println();
} 
}
}