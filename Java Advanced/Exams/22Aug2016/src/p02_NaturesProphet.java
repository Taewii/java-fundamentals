import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.System.in;

public class p02_NaturesProphet {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        int[] dimensions = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] garden = new int[rows][cols];

        fillMatrix(garden);

        String input;
        while (!"bloom bloom plow".equalsIgnoreCase(input = reader.readLine())) {
            int[] seed = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            int row = seed[0];
            int col = seed[1];

            bloomFlowers(rows, cols, garden, row, col);
        }
        printMatrix(garden);
    }

    private static void printMatrix(int[][] garden) {
        StringBuilder result = new StringBuilder();
        for (int[] ints : garden) {
            for (int anInt : ints) {
                result.append(anInt).append(" ");
            }
            result.append(System.lineSeparator());
        }
        System.out.println(result);
    }

    private static void bloomFlowers(int rows, int cols, int[][] garden, int row, int col) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == row || j == col) {
                    garden[i][j]++;
                }
            }
        }
    }

    private static void fillMatrix(int[][] garden) {
        for (int i = 0; i < garden.length; i++) {
            for (int j = 0; j < garden[i].length; j++) {
                garden[i][j] = 0;
            }
        }
    }
}
