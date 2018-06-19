import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class p08_FindTheSmallestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        List<Integer> numbers = Arrays.stream(reader.readLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> smallestNumberIndex = nums -> {
            int smallestNum = Integer.MAX_VALUE;
            int smallestIndex = 0;

            for (int i = 0; i < nums.size(); i++) {
                int current = nums.get(i);

                if (current <= smallestNum) {
                    smallestNum = current;
                    smallestIndex = i;
                }
            }
            return smallestIndex;
        };

        System.out.println(smallestNumberIndex.apply(numbers));
    }
}
