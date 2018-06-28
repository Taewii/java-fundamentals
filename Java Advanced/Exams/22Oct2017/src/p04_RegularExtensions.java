import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.in;

public class p04_RegularExtensions {     //85/100, 1 test is incorrect
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String text = reader.readLine();
        String pattern;
        while (!"Print".equals(pattern = reader.readLine())) {
            if (!pattern.contains("%")) {
                if (text.contains(pattern)) {
                    String reversed = new StringBuilder(pattern).reverse().toString();
                    text = text.replaceAll(Pattern.quote(pattern), reversed);
                }
            } else {
                char[] patternToCharArr = pattern.toCharArray();
                StringBuilder regexPattern = new StringBuilder();

                for (char ch : patternToCharArr) {
                    if (ch == '%') {
                        regexPattern.append("[\\S]*");
                    } else {
                        if (needsEscaping(ch)) {
                            regexPattern.append("\\").append(ch);
                        } else {
                            regexPattern.append(ch);
                        }
                    }
                }

                Pattern newPattern = Pattern.compile(regexPattern.toString());
                Matcher matcher = newPattern.matcher(text);

                while (matcher.find()) {
                    StringBuilder reversed = new StringBuilder(matcher.group(0)).reverse();
                    text = text.replaceAll(Pattern.quote(matcher.group(0)), reversed.toString());
                }
            }
        }
        System.out.println(text);
    }

    private static boolean needsEscaping(char c) {
        String chars = "\"[\\\\^$.|?*+()\"";
        for (char o : chars.toCharArray()) {
            if (c == o) {
                return true;
            }
        }
        return false;
    }
}
