import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import static java.lang.System.in;

public class p05_FilterByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        int n = Integer.parseInt(reader.readLine());
        Map<String, Integer> people = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] input = reader.readLine().split(", ");
            people.putIfAbsent(input[0], Integer.parseInt(input[1]));
        }

        String condition = reader.readLine();
        int ageCondition = Integer.parseInt(reader.readLine());
        String format = reader.readLine();

        Predicate<Integer> test = a -> a < ageCondition;

        BiFunction<String, Predicate<Integer>, Predicate<Integer>> func = (a, b) -> {
            if ("younger".equals(a)) {
                return b;
            } else {
                return b.negate();
            }
        };

        BiConsumer<String, Map.Entry<String, Integer>> printer = (a, b) -> {
            switch (a) {
                case "name":
                    System.out.printf("%s%n", b.getKey());
                    break;
                case "age":
                    System.out.printf("%d%n", b.getValue());
                    break;
                case "name age":
                    System.out.printf("%s - %d%n", b.getKey(), b.getValue());
                    break;
            }
        };

        for (Map.Entry<String, Integer> entry : people.entrySet()) {
            if (func.apply(condition, test).test(entry.getValue())) {
                printer.accept(format, entry);
            }
        }
    }
}
