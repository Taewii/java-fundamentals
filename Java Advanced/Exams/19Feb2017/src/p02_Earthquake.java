import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class p02_Earthquake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Deque<Deque> sequences = new ArrayDeque<>();
        List<Integer> seismicities = new ArrayList<>();
        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0) {
            Deque<Integer> currentSeq = Arrays.stream(reader.readLine().split(" "))
                    .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
            sequences.add(currentSeq);
        }

        while (!sequences.isEmpty()) {
            Deque<Integer> current = sequences.pop();

            int num = current.pop();
            seismicities.add(num);
            while (!current.isEmpty()) {
                int wave = current.peek();

                if (num >= wave) {
                    current.remove();
                } else {
                    break;
                }
            }

            if (!current.isEmpty()) {
                sequences.add(current);
            }
        }

        System.out.println(seismicities.size());
        System.out.println(seismicities.toString().replaceAll("[\\[\\],]", ""));
    }
}
