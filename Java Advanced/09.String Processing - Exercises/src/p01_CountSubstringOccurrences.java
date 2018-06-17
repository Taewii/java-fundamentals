import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class p01_CountSubstringOccurrences {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String text = reader.readLine().toLowerCase();
        String str = reader.readLine().toLowerCase();

        int counter = 0;
        int index = 0;

        while (true) {

            if (text.indexOf(str, index) != -1) {
                index = text.indexOf(str, index);
                index++;
                counter++;
            } else {
                break;
            }
        }

        System.out.println(counter);
    }
}
