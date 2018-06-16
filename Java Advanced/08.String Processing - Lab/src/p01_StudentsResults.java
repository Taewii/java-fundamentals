import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class p01_StudentsResults {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String[] input = reader.readLine().split("[\\s+\\-,]+");

        System.out.printf("%-10s|%7s|%7s|%7s|%7s|%n", "Name", "JAdv", "JavaOOP", "AdvOOP", "Average");
        System.out.printf("%-10s|%7.2f|%7.2f|%7.2f|%7.4f|",
                input[0],
                Double.parseDouble(input[1]),
                Double.parseDouble(input[2]),
                Double.parseDouble(input[3]),
                (Double.parseDouble(input[1]) + Double.parseDouble(input[2]) + Double.parseDouble(input[3])) / 3);
    }
}
