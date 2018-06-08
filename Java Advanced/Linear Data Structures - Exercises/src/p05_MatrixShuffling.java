import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p05_MatrixShuffling { // there's a way shorter solution if I try catch the index out of range exception
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimesions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int rows = dimesions[0];
        int cols = dimesions[1];

        String[][] matrix = new String[rows][cols];

        fillMatrix(scanner, rows, cols, matrix);

        while (true) {
            String commands = scanner.nextLine();

            if ("END".equals(commands)) {
                break;
            }

            List<String> tokens = Arrays.stream(commands.split(" ")).collect(Collectors.toList());

            if (!isInputValid(rows, cols, tokens)) {
                System.out.println("Invalid input!");
            } else {
                int row1 = Integer.parseInt(tokens.get(1));
                int col1 = Integer.parseInt(tokens.get(2));
                int row2 = Integer.parseInt(tokens.get(3));
                int col2 = Integer.parseInt(tokens.get(4));

                String firstIndex = matrix[row1][col1];
                String secondIndex = matrix[row2][col2];

                matrix[row1][col1] = secondIndex;
                matrix[row2][col2] = firstIndex;

                printMatrix(matrix);
            }
        }
    }

    private static boolean isInputValid(int rows, int cols, List<String> tokens) {
        if (!tokens.contains("swap") || tokens.size() != 5) {
            return false;
        }

        int row1 = Integer.parseInt(tokens.get(1));
        int col1 = Integer.parseInt(tokens.get(2));
        int row2 = Integer.parseInt(tokens.get(3));
        int col2 = Integer.parseInt(tokens.get(4));

        if (row1 > rows || row2 > rows || col1 > cols || col2 > cols) {
            return false;
        }

        for (int i = 1; i < tokens.size(); i++) {
            int num = Integer.parseInt(tokens.get(i));
            if (num < 0) {
                return false;
            }
        }
        return true;
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] ints : matrix) {
            for (String anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(Scanner scanner, int rows, int cols, String[][] matrix) {
        for (int i = 0; i < rows; i++) {
            String[] nums = scanner.nextLine().split(" ");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = nums[j];
            }
        }
    }
}