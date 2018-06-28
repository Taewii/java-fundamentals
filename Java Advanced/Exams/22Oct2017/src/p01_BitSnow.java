import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.System.in;

public class p01_BitSnow {
    private static final int BITS = 16;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        int[] numbers = Arrays.stream(reader.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        for (int i = numbers.length - 1; i > 0; i--) {
            int firstValue = numbers[i];

            numbers[i] = numbers[i] | numbers[i - 1];
            numbers[i - 1] &= firstValue;

            for (int j = i - 2; j >= 0 ; j--) {
                firstValue = numbers[i];
                numbers[i] = numbers[i] | numbers[j];
                numbers[j] &= firstValue;
            }
        }

        System.out.println(Arrays.toString(numbers).replaceAll("[\\[\\]]", ""));
    }
}