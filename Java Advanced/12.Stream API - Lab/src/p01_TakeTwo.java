import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.System.in;

public class p01_TakeTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Arrays.stream(reader.readLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .distinct()
                .filter(x -> x >= 10 && x <= 20)
                .limit(2)
                .forEach(x -> System.out.print(x + " "));
    }
}
