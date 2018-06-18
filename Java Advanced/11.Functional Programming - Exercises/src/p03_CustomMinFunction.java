import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

import static java.lang.System.in;

public class p03_CustomMinFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Function<int[], Integer> minNum = num -> {
            int min = Integer.MAX_VALUE;
            for (int i : num) {
                if (i < min) {
                    min = i;
                }
            }
            return min;
        };

        System.out.println(minNum.apply(nums));
    }
}
