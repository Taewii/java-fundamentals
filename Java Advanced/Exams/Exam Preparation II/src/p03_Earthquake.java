import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class p03_Earthquake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        int n = Integer.parseInt(reader.readLine());

        Deque<ArrayDeque<Integer>> sequences = new ArrayDeque<>();
        List<Integer> seismicitiesFound = new ArrayList<>();

        while (n-- > 0) {
            ArrayDeque<Integer> deque = Arrays.stream(reader.readLine().split(" "))
                    .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
            sequences.add(deque);
        }

        while (!sequences.isEmpty()) {
            ArrayDeque<Integer> current = sequences.remove();

            int num = current.remove();
            seismicitiesFound.add(num);

            while (!current.isEmpty()) {
                int wave = current.peek();
                if (wave <= num) {
                    current.remove();
                } else {
                    break;
                }
            }

            if (!current.isEmpty()) {
                sequences.add(current);
            }
        }

        System.out.println(seismicitiesFound.size());
        System.out.println(seismicitiesFound.toString().replaceAll("[\\[\\],]", ""));
    }
}
