import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

import static java.lang.System.in;

public class p05_Palindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String[] text = reader.readLine().split("[,?!.\\s]+");

        Set<String> set = new TreeSet<>();

        for (String word : text) {
            if (word.equals(new StringBuilder(word).reverse().toString())) {
                set.add(word);
            }
        }

        System.out.println(set);
    }
}
