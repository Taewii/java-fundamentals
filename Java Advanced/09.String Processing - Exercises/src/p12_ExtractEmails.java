import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.in;

public class p12_ExtractEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Pattern pattern = Pattern.compile("(^|\\s)[A-Za-z0-9]+[\\-_.]*[A-Za-z0-9]+@([A-Za-z]+[\\-]*[A-Za-z]+\\.)+[a-z]+(\\.|,|\\s|$)");

        String input;
        while (!"end".equals(input = reader.readLine())) {

            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                if (matcher.group().endsWith(".") || matcher.group().endsWith(",")) {
                    System.out.println(matcher.group().substring(0, matcher.group().length() - 1));
                } else {
                    System.out.println(matcher.group());
                }
            }
        }
    }
}
