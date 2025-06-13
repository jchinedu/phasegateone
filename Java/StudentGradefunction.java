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

    for (int index = 0; index <= (39 + (numberOfSubjects * (numberOfSubjects/2))); index++) {
        System.out.print("=");
    }
    System.out.println();

    System.out.printf("%-8s", "Student");
    for (int j = 0; j < numberOfSubjects; j++) {
        System.out.printf("%-8s", "Sub" + (j + 1));
    }
    System.out.printf("%-8s%-8s%-8s\n", "Total", "Average", "Position");

    for (int index = 0; index <= (39 + (numberOfSubjects * (numberOfSubjects/2))); index++) {
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
        for (int i = 0; i < (39 + (numberOfSubjects * (numberOfSubjects/2))); i++) {
            System.out.print("=");
        }
        System.out.println();
    }
}
}