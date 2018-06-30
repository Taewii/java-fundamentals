import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.in;

public class p03_NMS {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        List<String> words = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        char previous = ' ';

        String input;
        while (!"---NMS SEND---".equalsIgnoreCase(input = reader.readLine())) {
            char[] sequence = input.toCharArray();

            for (char current : sequence) {
                word.append(previous);
                if (Character.toLowerCase(previous) > Character.toLowerCase(current)) {
                    words.add(word.toString());
                    word.delete(0, word.length());
                }
                previous = current;
            }
        }

        if (word.length() == 0 || Character.toLowerCase(word.charAt(word.length() - 1)) <= Character.toLowerCase(previous)) {
            word.append(previous);
            words.add(word.toString());
        } else {
            words.add(word.toString());
            words.add(previous + "");
        }

        String delimiter = reader.readLine();

        StringBuilder result = new StringBuilder();
        for (String s : words) {
            result.append(s.trim()).append(delimiter);
        }
        System.out.println(result.substring(0, result.length() - delimiter.length()));
    }
}
