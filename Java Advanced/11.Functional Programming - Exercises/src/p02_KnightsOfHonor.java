import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

import static java.lang.System.in;

public class p02_KnightsOfHonor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String[] input = reader.readLine().split(" ");

        Consumer<String[]> print = names -> {
            for (String name : names) {
                System.out.println("Sir " + name);
            }
        };

        print.accept(input);
    }
}
