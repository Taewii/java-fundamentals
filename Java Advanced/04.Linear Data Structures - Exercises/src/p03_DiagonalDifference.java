import java.util.Scanner;

public class p03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];

        for (int rows = 0; rows < n; rows++) {
            String[] nums = scanner.nextLine().split(" ");
            for (int cols = 0; cols < n; cols++) {
                matrix[rows][cols] = Integer.parseInt(nums[cols]);
            }
        }

        int firstSum = 0;
        int secondSum = 0;

        for (int i = 0; i < n; i++) {
            firstSum += matrix[i][i];
            secondSum += matrix[i][n - 1 - i];
        }

        System.out.println(Math.abs(firstSum - secondSum));
    }
}
