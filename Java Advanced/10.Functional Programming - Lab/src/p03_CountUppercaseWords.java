import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.lang.System.in;

public class p03_CountUppercaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String[] text = reader.readLine().split(" ");

        Predicate<String> isUppercase = a -> a.charAt(0) == a.toUpperCase().charAt(0);

        List<String> uppercaseWords = new ArrayList<>();

        for (String word : text) {
            if (isUppercase.test(word)) {
                uppercaseWords.add(word);
            }
        }

        System.out.println(uppercaseWords.size());
        System.out.println(String.join("\n", uppercaseWords));
    }
}
