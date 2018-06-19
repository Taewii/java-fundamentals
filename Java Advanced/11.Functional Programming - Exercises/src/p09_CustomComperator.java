import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p09_CustomComperator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Integer> evenNums = new ArrayList<>();
        List<Integer> oddNums = new ArrayList<>();

        for (int number : numbers) {
            if (number % 2 == 0) {
                evenNums.add(number);
            } else {
                oddNums.add(number);
            }
        }
        evenNums.sort(Integer::compareTo);
        oddNums.sort(Integer::compareTo);
        for (Integer evenNum : evenNums) {
            System.out.print(evenNum + " ");
        }

        for (Integer oddNum : oddNums) {
            System.out.print(oddNum + " ");
        }
    }
}
