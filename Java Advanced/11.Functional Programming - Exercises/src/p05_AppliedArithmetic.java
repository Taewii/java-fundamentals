import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

import static java.lang.System.in;

public class p05_AppliedArithmetic {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        int[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String command;
        while (!"end".equals(command = reader.readLine())) {

            switch (command) {
                case "add":
                    numbers = Arrays.stream(numbers).map(x -> x + 1).toArray();
                    break;
                case "multiply":
                    numbers = Arrays.stream(numbers).map(x -> x * 2).toArray();
                    break;
                case "subtract":
                    numbers = Arrays.stream(numbers).map(x -> x - 1).toArray();
                    break;
                case "print":
                    System.out.println(Arrays.toString(numbers).replaceAll("[\\[\\],]", ""));
                    break;
            }
        }
    }
}
