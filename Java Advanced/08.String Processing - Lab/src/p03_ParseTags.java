import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class p03_ParseTags {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String text = reader.readLine();

        String opening = "<upcase>";
        String closing = "</upcase>";

        while (text.contains(opening)) {
            String textToReplace = text.substring(text.indexOf(opening) + 8 , text.indexOf(closing));
            text = text.replace(textToReplace, textToReplace.toUpperCase());
            text = text.replaceFirst(closing, "");
            text = text.replaceFirst(opening, "");

        }

        System.out.println(text);
    }
}
