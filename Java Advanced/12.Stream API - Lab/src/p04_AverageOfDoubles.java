import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class p04_AverageOfDoubles {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        List<String> numbers = Arrays.stream(reader.readLine().split(" ")).collect(Collectors.toList());

        OptionalDouble num = numbers.stream().filter(x -> !x.isEmpty()).mapToDouble(Double::parseDouble).average();

        if (num.isPresent()) {
            System.out.printf("%.2f", num.getAsDouble());
        } else {
            System.out.println("No match");
        }
    }
}
