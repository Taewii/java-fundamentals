import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class p03_TextFilter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String[] bannedWords = reader.readLine().split(", ");
        String text = reader.readLine();

        for (String bannedWord : bannedWords) {
            text = text.replaceAll(bannedWord, censor(bannedWord.length()));
        }

        System.out.println(text);
    }

    private static String censor(int count) {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < count; i++) {
            text.append("*");
        }
        return text.toString();
    }
}
