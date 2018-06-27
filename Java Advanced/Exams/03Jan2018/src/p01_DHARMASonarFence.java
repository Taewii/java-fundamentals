import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class p01_DHARMASonarFence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String input;
        while (!"Reprogram".equals(input = reader.readLine())) {
            int num = Integer.parseInt(input);

            for (int i = 0; i < 32 - 1; i++) {
                int firstDigit = num >> (31 - i) & 1;
                int secondDigit = (num >> (31 - i - 1) & 1);

                if (firstDigit == secondDigit) {
                    int position = 31 - i;
                    num = num ^ 1 << (position);
                    num = num ^ 1 << (position - 1);

                    i++;
                }
            }
            System.out.println(Long.toString(num & 0xFFFFFFFFL));
        }
    }
}
