import java.util.Scanner;

public class SumValidScoreInput {
    public static void main(String[] args) {
        int sum = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("enter 10 scores ");
        for (int i = 1; i <= 10; i++) {
            int score = input.nextInt();
            if (score >= 0) {
                sum += score;
            }

        }
        System.out.print(sum);
    }
}
