
import java.util.Arrays;
import java.util.Scanner;

public class FireDrillThree {
    public static int[] taskOne() {
        Scanner input = new Scanner(System.in);
        int[] scores = new int[10];
        System.out.println("Enter 10 scores:");
        for (int i = 0; i < scores.length; i++) {
            scores[i] = input.nextInt();
        }
        return scores;
    }

    public static void taskTwo(int[] scores) {
        for (int i = 0; i < scores.length; i++) {
            System.out.println(scores[i]);
        }
    }

    public static void taskThree(int[] scores) {
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i] + " ");
        }
    }


    public static int[] taskFour(int[] arr) {
        int[] Newarr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                Newarr[i] = arr[i];
            }
        }
        return Newarr;
    }

    public static int[] taskFive(int[] arr) {
        int[] newarr = new int[10];
        for (int i = 1; i < arr.length; i++) {
            if (i % 2 != 0) {
                newarr[i] = arr[i];
            }
        }
        return newarr;
    }

    public static int taskSix(int[] Newarr) {
        int sum = 0;
        for (int i = 1; i < Newarr.length; i++) {
            sum += Newarr[i];
        }
        return sum;

    }
    public static int taskSeven(int[] newarr) {
        int sum = 0;
        for (int i = 1; i < newarr.length; i++) {
            sum += newarr[i];
        }
        return sum;

    }
    public static void main(String[] args) {
        int[] scores = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(Arrays.toString(taskFour(scores)));

    }

}

