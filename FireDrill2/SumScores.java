import java.util.Scanner;

public class SumScores {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            System.out.print("enter scores" + i);
            int number = input.nextInt();

            sum += number;
        }
        System.out.print(sum);


    }
}
