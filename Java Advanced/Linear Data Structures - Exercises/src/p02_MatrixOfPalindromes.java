import java.util.Scanner;

public class p02_MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        String[][] matrix = new String[rows][cols];

        fillMatrix(rows, cols, matrix);
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(int rows, int cols, String[][] matrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char firstChar = (char)(97 + row);
                char middleChar = (char)(97 + row + col);
                String word = "" + firstChar + middleChar + firstChar;
                matrix[row][col] = word;
            }
        }
    }
}
