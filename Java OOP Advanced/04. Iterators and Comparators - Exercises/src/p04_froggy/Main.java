package p04_froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split(", | "))
                .map(Integer::parseInt).collect(Collectors.toList());

        Lake<Integer> lake = new Lake<>(numbers);

        StringBuilder builder = new StringBuilder();
        for (Integer integer : lake) {
            builder.append(integer).append(", ");
        }

        System.out.println(builder.substring(0, builder.length() - 2));
    }
}
