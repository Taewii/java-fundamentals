import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.in;

public class p04_CountSameValuesInArray {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String[] numbers = reader.readLine().split(" ");

        Map<String, Integer> numberCount = new HashMap<>();

        for (String number : numbers) {
            numberCount.putIfAbsent(number, 0);
            numberCount.put(number, numberCount.get(number) + 1);
        }

        for (Map.Entry<String, Integer> entry : numberCount.entrySet()) {
            System.out.printf("%s - %d times%n", entry.getKey(), entry.getValue());
        }
    }
}
