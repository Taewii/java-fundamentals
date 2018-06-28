import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class p02_LittleAlchemy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Deque<Integer> table = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        int gold = 0;

        String input;
        while (!"Revision".equals(input = reader.readLine())) {
            String[] tokens = input.split(" ");
            String command = tokens[0];
            int n = Integer.parseInt(tokens[2]);

            if ("Apply".equals(command)) {
                for (int i = 0; i < n; i++) {
                    if (!table.isEmpty()) {
                        int stone = table.pop();

                        stone--;
                        if (stone == 0) {
                            gold++;
                        } else {
                            table.add(stone);
                        }
                    }
                }
            } else {
                if (gold > 0) {
                    table.add(n);
                    gold--;
                }
            }
        }

        System.out.println(table.toString().replaceAll("[\\[\\],]", ""));
        System.out.println(gold);
    }
}
