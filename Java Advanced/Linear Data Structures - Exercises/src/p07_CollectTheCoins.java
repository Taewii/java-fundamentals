import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p07_CollectTheCoins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inputs = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            String input = scanner.nextLine();
            inputs.add(input);
        }

        char[] moves = scanner.nextLine().toCharArray();

        ArrayList<ArrayList<Character>> matrix = new ArrayList<>();

        fillMatrix(inputs, matrix);

        int currentRow = 0;
        int currentCol = 0;

        int coins = 0;
        int hitWall = 0;

        for (char move : moves) {
            switch (move) {
                case '>':
                    currentCol++;
                    if (currentCol >= matrix.get(currentRow).size()) {
                        currentCol--;
                        hitWall++;
                    } else if (matrix.get(currentRow).get(currentCol) == '$') {
                        coins++;
                    }
                    break;
                case '<':
                    currentCol--;
                    if (currentCol < 0) {
                        currentCol++;
                        hitWall++;
                    } else if (matrix.get(currentRow).get(currentCol) == '$') {
                        coins++;
                    }
                    break;
                case '^':
                    currentRow--;
                    if (currentRow < 0) {
                        currentRow++;
                        hitWall++;
                    } else if (matrix.get(currentRow).get(currentCol) == '$') {
                        coins++;
                    }
                    break;
                case 'V':
                    currentRow++;
                    if (currentRow > 3 || currentCol >= matrix.get(currentRow).size()) {
                        currentRow--;
                        hitWall++;
                    } else if (matrix.get(currentRow).get(currentCol) == '$') {
                        coins++;
                    }
                    break;
            }
        }

        System.out.println("Coins = " + coins);
        System.out.println("Walls = " + hitWall);
    }

    private static void fillMatrix(List<String> inputs, ArrayList<ArrayList<Character>> matrix) {
        for (int rows = 0; rows < 4; rows++) {
            char[] line = inputs.get(rows).toCharArray();
            ArrayList<Character> list = new ArrayList<>();
            for (char aLine : line) {
                list.add(aLine);
            }
            matrix.add(list);
        }
    }
}
