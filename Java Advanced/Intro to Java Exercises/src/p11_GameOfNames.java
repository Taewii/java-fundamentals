import java.util.Scanner;

public class p11_GameOfNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[] players = new String[n];
        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            String player = scanner.nextLine();
            int score = Integer.parseInt(scanner.nextLine());

            players[i] = player;
            scores[i] = score;
        }

        for (int i = 0; i < players.length; i++) {
            String player = players[i];
            for (int j = 0; j < player.length(); j++) {
                if (player.charAt(j) % 2 == 0) {
                    scores[i] += player.charAt(j);
                } else {
                    scores[i] -= player.charAt(j);
                }
            }
        }

        int bestIndex = Integer.MIN_VALUE;
        int bestScore = Integer.MIN_VALUE;

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > bestScore) {
                bestIndex = i;
                bestScore = scores[i];
            }
        }

        System.out.printf("The winner is %s - %d points", players[bestIndex], bestScore);
    }
}
