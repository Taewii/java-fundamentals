import java.util.Arrays;
import java.util.Scanner;

public class p13_BlurFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int blurAmount = Integer.parseInt(scanner.nextLine());
        int[] size = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int rows = size[0];
        int cols = size[1];

        long[][] matrix = new long[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            String[] input = scanner.nextLine().split(" ");
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = Integer.parseInt(input[j]);
            }
        }

        int[] coordinates = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int targetRow = coordinates[0];
        int targetCol = coordinates[1];

        int right = Math.min(targetCol + 1, cols);
        int left = Math.max(targetCol - 1, 0);
        int top = Math.max(targetRow - 1, 0);
        int bot = Math.min(targetRow + 1, rows);

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if ((left <= col && col <= right) && (top <= row && row <= bot)) {
                    System.out.printf("%d ", matrix[row][col] + blurAmount);
                } else {
                    System.out.printf("%d ", matrix[row][col]);
                }
            }
            System.out.println();
        }
    }
}
