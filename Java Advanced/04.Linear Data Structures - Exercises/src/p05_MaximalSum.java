import java.util.Arrays;
import java.util.Scanner;

public class p05_MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        fillMatrix(scanner, rows, cols, matrix);

        int bestSum = Integer.MIN_VALUE;
        int indexRow = 0;
        int indexCol = 0;

        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int sum = 0;
                for (int i = 0; i < 3; i++) {
                    sum += matrix[row + i][col] + matrix[row + i][col + 1] + matrix[row + i][col + 2];
                }

                if (sum > bestSum) {
                    bestSum = sum;
                    indexRow = row;
                    indexCol = col;
                }
            }
        }
        printMatrix(matrix, bestSum, indexRow, indexCol);
    }

    private static void printMatrix(int[][] matrix, int bestSum, int indexRow, int indexCol) {
        System.out.println("Sum = " + bestSum);
        for (int i = 0; i < 3; i++) {
            System.out.println(matrix[indexRow + i][indexCol] +
                    " " + matrix[indexRow + i][indexCol + 1] +
                    " " + matrix[indexRow + i][indexCol + 2]);
        }
    }

    private static void fillMatrix(Scanner scanner, int rows, int cols, int[][] matrix) {
        for (int i = 0; i < rows; i++) {
            String[] nums = scanner.nextLine().split(" ");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(nums[j]);
            }
        }
    }
}
