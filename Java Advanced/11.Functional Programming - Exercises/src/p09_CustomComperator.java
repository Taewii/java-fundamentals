import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p09_CustomComperator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] numbersAsStr = reader.readLine().split("\\s+");
        Integer[] numbers = new Integer[numbersAsStr.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numbersAsStr[i]);
        }

        Comparator<Integer> integerComparator = (a, b) -> {
            if (a % 2 == 0 && b % 2 != 0) {
                return -1;
            } else if (a % 2 != 0 && b % 2 == 0) {
                return 1;
            } else {
                return a - b;
            }
        };

        Arrays.sort(numbers, integerComparator);
        Arrays.stream(numbers).forEach(x -> System.out.print(x + " "));
    }
}
