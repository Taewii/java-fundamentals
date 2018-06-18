import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

import static java.lang.System.in;

public class p01_ConsumerPrint {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String[] names = reader.readLine().split(" ");

        Consumer<String[]> print = a -> {
            for (String s : a) {
                System.out.println(s);
            }
        };

        print.accept(names);
    }
}
