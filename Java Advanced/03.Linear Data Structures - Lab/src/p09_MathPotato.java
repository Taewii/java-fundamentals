import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class p09_MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> players = new ArrayDeque<>();
        Collections.addAll(players, input);

        int cycle = 1;

        while (players.size() > 1) {
            for (int i = 1; i < n; i++) {
                players.offer(players.poll());
            }

            if (!isPrime(cycle)) {
                System.out.println("Removed " + players.poll());
            } else {
                System.out.println("Prime " + players.peek());
            }
            cycle++;
        }

        System.out.println("Last is " + players.poll());
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {

            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
