import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

import static java.lang.System.in;

public class p04_FindEvenOrOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        int[] dimensions = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Integer> nums = new ArrayList<>();

        for (int i = dimensions[0]; i <= dimensions[1]; i++) {
            nums.add(i);
        }

        String oddOrEven = reader.readLine();

        BiConsumer<List<Integer>, String> OddOrEven = (a, b) -> {
            if ("odd".equals(b)) {
                for (Integer integer : a) {
                    if (integer % 2 != 0) {
                        System.out.print(integer + " ");
                    }
                }
            } else {
                for (Integer integer : a) {
                    if (integer % 2 == 0) {
                        System.out.print(integer + " ");
                    }
                }
            }
        };

        OddOrEven.accept(nums, oddOrEven);
    }
}
