import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

import static java.lang.System.in;

public class p10_ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        int n = Integer.parseInt(reader.readLine());
        int[] sequence = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        BiPredicate<Integer, Integer> isDivisible = (num, divider) -> num % divider == 0;

        for (int divider : sequence) {
            for (int i = 0; i < numbers.size(); i++) {
                Integer number = numbers.get(i);
                if (!isDivisible.test(number, divider)) {
                    numbers.set(i, 0);
                }
            }
        }

        numbers.removeIf(x -> x == 0);
        numbers.forEach(x -> System.out.print(x + " "));
    }
}
