public class StudentGradefunction {
   public static void calculateTotals(int[][] scores, int[] totals) {
    int numberOfStudents = scores.length;
    int numberOfSubjects = scores[0].length;

    for (int i = 0; i < numberOfStudents; i++) {
        int total = 0;
        for (int j = 0; j < numberOfSubjects; j++) {
            total += scores[i][j];
        }
        totals[i] = total;
    }
}

public static void calculateAverages(int[] totals, double[] averages, int numberOfSubjects) {
    int numberOfStudents = totals.length;

    for (int i = 0; i < numberOfStudents; i++) {
        averages[i] = (double) totals[i] / numberOfSubjects;
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

    for (int index = 0; index <= (39 + (numberOfSubjects * (numberOfSubjects) * 1.5)); index++) {
        System.out.print("=");
    }
    System.out.println();

    System.out.printf("%-8s", "Student");
    for (int j = 0; j < numberOfSubjects; j++) {
        System.out.printf("%-8s", "Sub" + (j + 1));
    }
    System.out.printf("%-8s%-8s%-8s\n", "Total", "Average", "Position");

    for (int index = 0; index <= (39 + (numberOfSubjects * (numberOfSubjects) * 1.5)); index++) {
        System.out.print("=");
    }
    System.out.println();

    for (int i = 0; i < numberOfStudents; i++) {
        System.out.printf("%-8d", i + 1);
        for (int j = 0; j < numberOfSubjects; j++) {
            System.out.printf("%-8d", scores[i][j]);
        }
        System.out.printf("%-8d%-8.2f%-8d\n", totals[i], averages[i], positions[i]);
    }

    for (int k = 0; k < 2; k++) {
        for (int i = 0; i < (39 + (numberOfSubjects * (numberOfSubjects) * 1.5)); i++) {
            System.out.print("=");
        }
        System.out.println();
    }
}
	public static void subjectSummary(int[][] scores, int passmark) {
    int numberOfStudents = scores.length;
    int numberOfSubjects = scores[0].length;

    for (int i = 0; i < numberOfSubjects; i++) {
     int total = 0;
     int passes = 0;
        int failures = 0;
        int highestScore = scores[0][i];
        int lowestScore = scores[0][i];
        int highestStudent = 1;
        int lowestStudent = 1;

        for (int student = 0; student < numberOfStudents; student++) {
            int score = scores[student][i];
            total += score;

            if (score >= passmark) {
                passes++;
            } else {
                failures++;
            }

            if (score > highestScore) {
                highestScore = score;
                highestStudent = student + 1;
            }

            if (score < lowestScore) {
                lowestScore = score;
                lowestStudent = student + 1;
            }
        }

        double average = (double) total / numberOfStudents;
	
	System.out.print("SUBJECT SUMMARY\n");
        System.out.printf("Subject %d\n", i + 1);
	System.out.printf("  Highest Scoring student is : Student %d scoring  %d\n", highestStudent, highestScore);
	System.out.printf("  Lowest Scoring student is : Student %d scoring  %d\n", lowestStudent, lowestScore );
        System.out.printf("  Total Score is : %d\n", total);
        System.out.printf("  Average Score is: %.2f\n", average);
        System.out.printf("  Number of Passes: %d\n", passes);
        System.out.printf("  Number of Fails: %d\n", failures);
    }
}


}