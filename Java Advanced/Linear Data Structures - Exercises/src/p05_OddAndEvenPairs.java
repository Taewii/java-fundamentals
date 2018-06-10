import java.util.Arrays;
import java.util.Scanner;

public class p05_OddAndEvenPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if (nums.length % 2 == 1) {
            System.out.println("invalid length");
        } else {
            for (int i = 0; i < nums.length - 1; i += 2) {
                int a = nums[i];
                int b = nums[i + 1];

                if (a % 2 == 0 && b % 2 == 0) {
                    System.out.printf("%d, %d -> both are even%n", a, b);
                } else if (a % 2 == 1 && b % 2 == 1) {
                    System.out.printf("%d, %d -> both are odd%n", a, b);
                } else {
                    System.out.printf("%d, %d -> different%n", a, b);
                }
            }
        }
    }
}
