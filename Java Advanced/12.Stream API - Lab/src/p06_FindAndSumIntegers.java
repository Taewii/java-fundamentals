import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class p06_FindAndSumIntegers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        List<String> input = Arrays.stream(reader.readLine().split(" ")).collect(Collectors.toList());

        OptionalInt num = input.stream().filter(x -> {
            try {
                Integer.parseInt(x);
                return true;
            } catch (Exception e) {
                return false;
            }
        }).mapToInt(Integer::parseInt).reduce((x, y) -> x + y);

        System.out.println(num.isPresent() ? num.getAsInt() : "No match");
    }
}
