import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p11_ReplaceTag {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        Pattern pattern = Pattern.compile("(<a).*(>)[^<]*(</a>)");

        String text = "";
        while (!"END".equals(input)){
            text += input+ "\n";
            input = reader.readLine();
        }

        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            String replacement = matcher.group(0).replace(matcher.group(1) , "[URL")
                    .replace(matcher.group(3), "[/URL]")
                    .replace(matcher.group(2),"]");
            text = text.replace(matcher.group(0),replacement);
        }
        System.out.println(text);
    }
}
