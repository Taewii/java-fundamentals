import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.in;

public class p06_ExtractTags {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Pattern pattern = Pattern.compile("<.+?>");

        String input;
        while (!"END".equals(input = reader.readLine())) {
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        }
    }
}
