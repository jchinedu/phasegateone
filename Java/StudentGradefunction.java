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
public static int[] findHardestSubject(int[][] scores, int passMark) {
    int numberOfSubjects = scores[0].length;
    int numberOfStudents = scores.length;
    int maxFailures = -1;
    int hardestSubject = -1;

    for (int k = 0; k < numberOfSubjects; k++) {
        int failures = 0;
        for (int student = 0; student < numberOfStudents; student++) {
            if (scores[student][k] < passMark) {
                failures++;
            }
        }
        if (failures > maxFailures) {
            maxFailures = failures;
            hardestSubject = k;
        }
    }
    return new int[]{hardestSubject, maxFailures};
}
public static int[] findEasiestSubject(int[][] scores, int passMark) {
    int numberOfSubjects = scores[0].length;
    int numberOfStudents = scores.length;
    int maxPasses = -1;
    int easiestSubject = -1;

    for (int i = 0; i < numberOfSubjects; i++) {
        int passes = 0;
        for (int student = 0; student < numberOfStudents; student++) {
            if (scores[student][i] >= passMark) {
                passes++;
            }
        }
        if (passes > maxPasses) {
            maxPasses = passes;
            easiestSubject = i;
        }
    }
    return new int[]{easiestSubject, maxPasses};
}
public static int[] findOverallHighestScore(int[][] scores) {
    int maxScore = -1;
    int studentIndex = -1;
    int subjectIndex = -1;

    for (int i = 0; i < scores.length; i++) {
        for (int j = 0; j < scores[0].length; j++) {
            if (scores[i][j] > maxScore) {
                maxScore = scores[i][j];
                studentIndex = i;
                subjectIndex = j;
            }
        }
    }
    return new int[]{studentIndex, subjectIndex, maxScore};
}
public static int[] findOverallLowestScore(int[][] scores) {
    int minScore = 101;
    int studentIndex = -1;
    int subjectIndex = -1;

    for (int i = 0; i < scores.length; i++) {
        for (int j = 0; j < scores[0].length; j++) {
            if (scores[i][j] < minScore) {
                minScore = scores[i][j];
                studentIndex = i;
                subjectIndex = j;
            }
        }
    }
    return new int[]{studentIndex, subjectIndex, minScore};
}
public static int findBestGraduatingStudent(int[] totals) {
    int maxTotal = -1;
    int bestStudent = -1;
    for (int i = 0; i < totals.length; i++) {
        if (totals[i] > maxTotal) {
            maxTotal = totals[i];
            bestStudent = i;
        }
    }
    return bestStudent;
}
public static int findWorstGraduatingStudent(int[] totals) {
    int minTotal = Integer.MAX_VALUE;
    int worstStudent = -1;
    for (int i = 0; i < totals.length; i++) {
        if (totals[i] < minTotal) {
            minTotal = totals[i];
            worstStudent = i;
        }
    }
    return worstStudent;
}
public static double[] calculateClassTotalAndAverage(int[] totals) {
    int sum = 0;
    for (int total : totals) {
        sum += total;
    }
    double average = (double) sum / totals.length;
    return new double[]{sum, average};
}

}