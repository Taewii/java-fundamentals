import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

import static java.lang.System.in;

public class p06_MagicExchangeableWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String[] input = reader.readLine().split(" ");

        Set<Character> first = new HashSet<>();
        Set<Character> second = new HashSet<>();

        for (char ch : input[0].toLowerCase().toCharArray()) {
            first.add(ch);
        }
        for (char ch : input[1].toLowerCase().toCharArray()) {
            second.add(ch);
        }

        boolean isExchangeable = first.size() == second.size();
        System.out.println(isExchangeable ? "true" : "false");
    }
}
