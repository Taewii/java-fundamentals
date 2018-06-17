import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class p08_MelrahShake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        StringBuilder text = new StringBuilder(reader.readLine());
        String pattern = reader.readLine();

        while (true) {

            int firstIndex = text.indexOf(pattern);
            int lastIndex = text.lastIndexOf(pattern);


            if((lastIndex == -1 || firstIndex == -1) || pattern.length() == 0){
                System.out.println("No shake.");
                System.out.println(text);
                break;
            }

            text = text.replace(firstIndex, firstIndex + pattern.length(), "");
            text = text.replace(lastIndex - pattern.length(), lastIndex, "");
            System.out.println("Shaked it.");

            int index = pattern.length() / 2;
            pattern = pattern.substring(0, index) + pattern.substring(index + 1);
        }
    }
}
