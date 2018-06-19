import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.BiPredicate;

import static java.lang.System.in;

public class p07_PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        int length = Integer.parseInt(reader.readLine());
        String[] names = reader.readLine().split(" ");

        BiPredicate<String, Integer> checkLength = (n, l) -> n.length() <= l;

        for (String name : names) {
            if (checkLength.test(name, length)) {
                System.out.println(name);
            }
        }
    }
}
