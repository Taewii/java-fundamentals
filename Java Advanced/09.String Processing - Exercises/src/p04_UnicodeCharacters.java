import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class p04_UnicodeCharacters {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        char[] text = reader.readLine().toCharArray();

        StringBuilder sb = new StringBuilder();

        for (char c : text) {
            sb.append( "\\u").append(Integer.toHexString(c | 0x10000).substring(1));
        }

        System.out.println(sb);
    }
}
