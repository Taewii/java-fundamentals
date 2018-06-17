import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.in;

public class p13_SentenceExtractor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String word = reader.readLine();
        String text = reader.readLine();

        Pattern pattern = Pattern.compile("(.+?)([!.?])+");
        Matcher matcher = pattern.matcher(text);

        while(matcher.find()){
            if(matcher.group(1).contains(" " + word + " ")){
                System.out.println(matcher.group().trim());
            }
        }
    }
}
