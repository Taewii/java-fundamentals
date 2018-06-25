import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.System.in;

public class p01_Shockwave {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        int[] size = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[size[0]][size[1]];

        for (int i = 0; i < size[0]; i++) {
            for (int j = 0; j < size[1]; j++) {
                matrix[i][j] = 0;
            }
        }

        String input;
        while (!"Here We Go".equals(input = reader.readLine())) {
            int[] tokens = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            int x1 = tokens[0];
            int x2 = tokens[1];
            int y1 = tokens[2];
            int y2 = tokens[3];

            for (int row = x1; row <= y1; row++) {
                for (int col = x2; col <= y2; col++) {
                    matrix[row][col]++;
                }
            }
        }

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
