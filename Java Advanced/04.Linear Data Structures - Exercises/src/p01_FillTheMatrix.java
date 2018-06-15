import java.util.Scanner;

public class p01_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int n = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = new int[n][n];

        if ("A".equals(pattern)) {
            fillMatrixApattern(n, matrix);
        } else {
            fillMatrixBpattern(n, matrix);
        }

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrixApattern(int n, int[][] matrix) {
        int counter = 1;

        for (int rows = 0; rows < n; rows++) {
            for (int cols = 0; cols < n; cols++) {
                matrix[cols][rows] = counter;
                counter++;
            }
        }
    }

    private static void fillMatrixBpattern(int n, int[][] matrix) {
        int counter = 1;

        for (int rows = 0; rows < n; rows++) {
            if (rows % 2 == 0) {
                for (int cols = 0; cols < n; cols++) {
                    matrix[cols][rows] = counter;
                    counter++;
                }
            } else {
                for (int cols = n - 1; cols >= 0; cols--) {
                    matrix[cols][rows] = counter;
                    counter++;
                }
            }
        }
    }
}
