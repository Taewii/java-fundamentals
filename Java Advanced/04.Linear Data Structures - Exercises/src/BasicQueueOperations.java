import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

import static java.lang.System.in;

public class BasicQueueOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        int[] commands = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int elementsToPush = commands[0];
        int elementsToPop = commands[1];
        int elementToCheck = commands[2];

        int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < elementsToPush; i++) {
            queue.add(input[i]);
        }

        for (int i = 0; i < elementsToPop; i++) {
            queue.poll();
        }

        if (queue.contains(elementToCheck)) {
            System.out.println("true");
        } else if (queue.isEmpty()) System.out.println(0);
        else {
            int minNum = Integer.MAX_VALUE;
            for (Integer integer : queue) {
                if (minNum >= integer) {
                    minNum = integer;
                }
            }
            System.out.println(minNum);
        }
    }
}
