import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static java.lang.System.in;

public class p03_ChessKnight {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        int n = 8;
        String[][] board = new String[n][n];
        fillChessBoard(reader, n, board);

        int startPosition = Integer.parseInt(reader.readLine());
        int currentRow = startPosition / 10;
        int currentCol = startPosition % 10;

        ArrayList<String> takenFigures = new ArrayList<>();
        int invalidMoves = 0;
        int outsideBoard = 0;
        String moves;
        while (!"END".equals(moves = reader.readLine())) {
            String[] tokens = moves.split(" -> ");
            int rowStart = Integer.parseInt(tokens[0].charAt(0) + "");
            int colStart = Integer.parseInt(tokens[0].charAt(1) + "");
            int rowEnd = Integer.parseInt(tokens[1].charAt(0) + "");
            int colEnd = Integer.parseInt(tokens[1].charAt(1) + "");

            if (rowStart == currentRow && colStart == currentCol) {
                if (isValidMove(rowStart, colStart, rowEnd, colEnd)) {
                    if (isInsideBoard(rowEnd, colEnd, n)) {
                        currentRow = rowEnd;
                        currentCol = colEnd;
                        if (!board[rowEnd][colEnd].equals(" ")) {
                            takenFigures.add(board[rowEnd][colEnd]);
                            board[rowEnd][colEnd] = " ";
                        }
                    } else {
                        outsideBoard++;
                    }
                } else {
                    invalidMoves++;
                }
            }
        }
        System.out.println("Pieces take: " + takenFigures.toString().replaceAll("[\\[\\]]", ""));
        System.out.println("Invalid moves: " + invalidMoves);
        System.out.println("Board out moves: " + outsideBoard);
    }

    private static void fillChessBoard(BufferedReader reader, int n, String[][] board) throws IOException {
        for (int i = 0; i < n; i++) {
            String[] pieces = reader.readLine().split("\\|");
            for (int j = 0; j < n; j++) {
                board[i][j] = pieces[j].equals("") ? " " : pieces[j];
            }
        }
    }

    private static boolean isValidMove(int rowStart, int colStart, int row, int col) {
        int rowDownBy2 = rowStart + 2;
        int rowUpBy2 = rowStart - 2;
        int colLeftBy2 = colStart - 2;
        int colRightBy2 = colStart + 2;

        int colRightBy1 = colStart + 1;
        int colLeftBy1 = colStart - 1;
        int rowDownBy1 = rowStart + 1;
        int rowUpBy1 = rowStart - 1;

        if ((row == rowDownBy2 || row == rowUpBy2) && (col == colRightBy1 || col == colLeftBy1)) {
            return true;
        }

        return (col == colLeftBy2 || col == colRightBy2) && (row == rowDownBy1 || row == rowUpBy1);
    }

    private static boolean isInsideBoard(int row, int col, int n) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }
}
