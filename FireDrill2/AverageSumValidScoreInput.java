import java.util.Scanner;

public class AverageSumValidScoreInput {
    public static void main(String[] args) {
        int sum = 0;
        int counter = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("enter 10 scores ");
        for (int i = 1; i <= 10; i++) {
            int score = input.nextInt();
            if (score >= 0) {
                counter++;
                sum += score;
            }

        }
        double avg = sum/counter;
        System.out.println(avg);
    }
}

