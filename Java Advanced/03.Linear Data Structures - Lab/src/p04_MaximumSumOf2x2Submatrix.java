import java.util.Arrays;
import java.util.Scanner;

public class p04_MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        int[][] matrix = new int[dimensions[0]][dimensions[1]];

        for (int rows = 0; rows < matrix.length; rows++) {
            String[] remainder = scanner.nextLine().split(", ");
            for (int cols = 0; cols < matrix[0].length; cols++) {
                matrix[rows][cols] = Integer.parseInt(remainder[cols]);
            }
        }

        int bestSum = Integer.MIN_VALUE;
        int indexRow = 0;
        int indexCol = 0;

        for (int rows = 0; rows < matrix.length - 1; rows++) {
            for (int cols = 0; cols < matrix[0].length - 1; cols++) {
                int sum = matrix[rows][cols] + matrix[rows][cols + 1] + matrix[rows + 1][cols] + matrix[rows + 1][cols + 1];

                if (sum > bestSum) {
                    bestSum = sum;
                    indexRow = rows;
                    indexCol = cols;
                }
            }
        }

        for (int i = indexRow; i < indexRow + 2; i++) {
            System.out.println(matrix[i][indexCol] + " " + matrix[i][indexCol + 1]);
        }
        System.out.println(bestSum);
    }
}
