import java.util.Arrays;
import java.util.Scanner;

public class p04_2x2SquaresInMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];

        fillMatrix(scanner, rows, cols, matrix);

        int counter = 0;

        counter = count2x2EqualElements(rows, cols, matrix, counter);

        System.out.println(counter);
    }

    private static int count2x2EqualElements(int rows, int cols, String[][] matrix, int counter) {
        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                if (matrix[row][col].equals(matrix[row][col + 1]) &&
                    matrix[row + 1][col].equals(matrix[row + 1][col + 1]) &&
                    matrix[row][col].equals(matrix[row + 1][col + 1])) {
                    counter++;
                }
            }
        }
        return counter;
    }

    private static void fillMatrix(Scanner scanner, int rows, int cols, String[][] matrix) {
        for (int i = 0; i < rows; i++) {
            String[] input = scanner.nextLine().split(" ");
            System.arraycopy(input, 0, matrix[i], 0, cols);
        }
    }
}
