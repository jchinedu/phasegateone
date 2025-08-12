import java.util.Scanner;

public class SumOfEvenIndexes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.print("enter scores" + i + " ");
                int number = input.nextInt();
                sum += number;
            }

        }
        System.out.println(sum);

    }
}
