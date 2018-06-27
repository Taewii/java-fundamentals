import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class p04_TheSwanStation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        ArrayDeque<Integer> theNumbers = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> ints = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayList<Integer> result = new ArrayList<>();

        while (result.size() != 6) {
            int firstNumber = theNumbers.pop();
            int integer = ints.pop();

            if (integer % firstNumber == 0) {
                result.add(integer);
            } else {
                theNumbers.push(firstNumber);
                ints.add(++integer);
            }
        }
        System.out.println(result.toString().replaceAll("[\\[\\]]", ""));
    }
}
