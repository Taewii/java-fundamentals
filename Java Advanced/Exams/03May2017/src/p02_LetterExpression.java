import javafx.print.Collation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class p02_LetterExpression {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String pattern = "[\\d]+";
        String input = reader.readLine();
        List<Integer> numbers = new ArrayList<>();
        Deque<String> symbols = Arrays.stream(input.split(pattern))
                .filter(x -> !x.isEmpty()).collect(Collectors.toCollection(ArrayDeque::new));

        Pattern pattern1 = Pattern.compile(pattern);
        Matcher matcher = pattern1.matcher(input);

        while (matcher.find()) {
            numbers.add(Integer.parseInt(matcher.group(0)));
        }

        long result = 0;
        for (int i = 0; i < numbers.size(); i++) {
            int num = numbers.get(i);
            if (i == 0) {
                result += num;
                continue;
            }
            String chars = "";
            if (!symbols.isEmpty()) {
                chars = symbols.pop().trim();
            }

            if (chars.length() % 2 == 0) {
                result += num;
            } else {
                result -= num;
            }
        }
        System.out.println(result);
    }
}
