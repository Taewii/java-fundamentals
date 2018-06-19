import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class p06_ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        List<Integer> numbers = Arrays.stream(reader.readLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int n = Integer.parseInt(reader.readLine());

        Collections.reverse(numbers);
        numbers.removeIf(x -> x % n == 0);
        numbers.forEach(x -> System.out.print(x + " "));
    }
}
