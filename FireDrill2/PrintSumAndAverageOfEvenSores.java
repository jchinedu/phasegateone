import java.util.Scanner;

public class PrintSumAndAverageOfEvenSores {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            System.out.print("enter scores" + i + " ");
            int number = input.nextInt();
            if (number % 2 == 0) {
                sum += number;
            }

        }
        System.out.println(sum);
        double avg = sum / 10;
        System.out.print(avg);
    }
}
