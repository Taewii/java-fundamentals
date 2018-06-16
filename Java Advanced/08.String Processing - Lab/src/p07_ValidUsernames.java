import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.in;

public class p07_ValidUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Pattern pattern = Pattern.compile("^[\\w-]{3,16}$");
        List<String> results = new ArrayList<>();

        String input;
        while (!"END".equals(input = reader.readLine())) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                results.add("valid");
            } else {
                results.add("invalid");
            }
        }

        if (results.contains("valid")) {
            for (String s : results) {
                System.out.println(s);
            }
        }
    }
}
