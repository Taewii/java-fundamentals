import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

import static java.lang.System.in;

public class p02_SumNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String[] input = reader.readLine().split(", ");

        Function<String[], int[]> parseNumbers = a -> {
            int[] nums = new int[a.length];
            for (int i = 0; i < a.length; i++) {
                nums[i] = Integer.parseInt(a[i]);
            }
            return nums;
        };
        int[] numbers = parseNumbers.apply(input);

        Function<int[], Integer> getCount = a -> a.length;
        int count = getCount.apply(numbers);

        Function<int[], Integer> getSum = a -> {
            int sum = 0;
            for (int i : a) {
                sum += i;
            }
            return sum;
        };
        int sum = getSum.apply(numbers);

        System.out.println("Count = " + count);
        System.out.println("Sum = " + sum);
    }
}
