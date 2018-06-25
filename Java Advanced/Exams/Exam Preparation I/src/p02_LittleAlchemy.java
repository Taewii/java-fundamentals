import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class p02_LittleAlchemy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> stones = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        int gold = 0;


        String line = reader.readLine();
        while (true) {
            String[] commandArgs = line.split(" ");
            switch (commandArgs[0]) {
                case "Apply":
                    gold = applyAcid(stones, gold, commandArgs[2]);
                    break;
                case "Air":
                    gold = airLeak(stones, gold, commandArgs[2]);
                    break;
                default:
                    printResult(stones, gold);
                    return;
            }
            line = reader.readLine();
        }
    }

    private static int airLeak(ArrayDeque<Integer> stones, int gold, String commandArg) {
        if (gold <= 0) {
            return gold;
        }
        gold--;
        stones.addLast(Integer.parseInt(commandArg));
        return gold;
    }

    private static int applyAcid(ArrayDeque<Integer> stones, int gold, String commandArg) {
        int acid = Integer.parseInt(commandArg);
        while (acid-- > 0 && !stones.isEmpty()) {
            int element = stones.pop();
            if (--element <= 0) {
                gold++;
            } else {
                stones.addLast(element);
            }
        }
        return gold;
    }

    private static void printResult(ArrayDeque<Integer> stones, int gold) {
        while (!stones.isEmpty()) {
            System.out.print(stones.pop() + " ");
        }
        System.out.println("\n" + gold);
    }
}