import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class p02_Snake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        int n = Integer.parseInt(reader.readLine());
        String[][] matrix = new String[n][n];
        String[] commands = reader.readLine().split(", ");

        for (int i = 0; i < n; i++) {
            String[] inputs = reader.readLine().split(" ");
            System.arraycopy(inputs, 0, matrix[i], 0, n);
        }

        int row = 0;
        int col = 0;
        int food = 0;
        int length = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j].equals("s")) {
                    row = i;
                    col = j;
                }
                if (matrix[i][j].equals("f")) {
                    food++;
                }
            }
        }

        for (String command : commands) {
            switch (command) {
                case "up":
                    if (row - 1 < 0) {
                        row = n - 1;
                    } else {
                        row -= 1;
                    }

                    if (matrix[row][col].equals("f")) {
                        food--;
                        length++;
                        if (food == 0) {
                            System.out.println("You win! Final snake length is " + length);
                            return;
                        }
                    }
                    if (matrix[row][col].equals("e")) {
                        System.out.println("You lose! Killed by an enemy!");
                    }
                    break;
                case "down":
                    if (row + 1 >= n) {
                        row = 0;
                    } else {
                        row += 1;
                    }

                    if (matrix[row][col].equals("f")) {
                        food--;
                        length++;
                        if (food == 0) {
                            System.out.println("You win! Final snake length is " + length);
                            return;
                        }
                    }
                    if (matrix[row][col].equals("e")) {
                        System.out.println("You lose! Killed by an enemy!");
                        return;
                    }
                    break;
                case "right":
                    if (col + 1 >= n) {
                        col = 0;
                    } else {
                        col += 1;
                    }

                    if (matrix[row][col].equals("f")) {
                        food--;
                        length++;
                        if (food == 0) {
                            System.out.println("You win! Final snake length is " + length);
                            return;
                        }
                    }
                    if (matrix[row][col].equals("e")) {
                        System.out.println("You lose! Killed by an enemy!");
                        return;
                    }
                    break;
                case "left":
                    if (col - 1 < 0) {
                        col = n - 1;
                    } else {
                        col -= 1;
                    }

                    if (matrix[row][col].equals("f")) {
                        food--;
                        length++;
                        if (food == 0) {
                            System.out.println("You win! Final snake length is " + length);
                            return;
                        }
                    }
                    if (matrix[row][col].equals("e")) {
                        System.out.println("You lose! Killed by an enemy!");
                    }
                    break;
            }
        }

        if (food == 0) {
            System.out.println("You win! Final snake length is " + length);
        } else {
            System.out.printf("You lose! There is still %d food to be eaten.", food);
        }
    }
}
