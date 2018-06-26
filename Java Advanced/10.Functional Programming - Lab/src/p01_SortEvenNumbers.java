import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class p01_SortEvenNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split(", ")).map(Integer::parseInt).collect(Collectors.toList());

        numbers.removeIf(n -> n % 2 != 0);
        System.out.println(numbers.toString().replaceAll("[\\[\\]]", ""));
        numbers.sort(Integer::compareTo);
        System.out.println(numbers.toString().replaceAll("[\\[\\]]", ""));
    }
}