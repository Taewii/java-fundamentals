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

        String input;
        while (!"here we go".equalsIgnoreCase(input = reader.readLine())) {
            int[] dimensions = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();

            int x1 = dimensions[0];
            int y1 = dimensions[1];
            int x2 = dimensions[2];
            int y2 = dimensions[3];

            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                 matrix[i][j]++;
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
