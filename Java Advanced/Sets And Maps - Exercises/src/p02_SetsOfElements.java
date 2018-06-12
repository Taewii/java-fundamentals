import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import static java.lang.System.in;

public class p02_SetsOfElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        int[] sizes = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Set<String> first = new LinkedHashSet<>();
        Set<String> second = new LinkedHashSet<>();

        for (int i = 0; i < sizes[0]; i++) {
            String input = reader.readLine();
            first.add(input);
        }

        for (int i = 0; i < sizes[1]; i++) {
            String input = reader.readLine();
            second.add(input);
        }

        for (String s : first) {
            if (second.contains(s)) {
                System.out.print(s + " ");
            }
        }
    }
}
