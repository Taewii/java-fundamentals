import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class p07_LettersChangeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String[] input = reader.readLine().split("\\s+");

        double sum = 0;

        for (String str : input) {
            char firstLetter = str.charAt(0);
            char lastLetter = str.charAt(str.length() - 1);
            int firstLetterPosition = Character.isLowerCase(firstLetter) ? -96 + (int)firstLetter : -64 + (int)firstLetter;
            int lastLetterPosition = Character.isLowerCase(lastLetter) ? -96 + (int)lastLetter : -64 + (int)lastLetter;
            double number = Integer.parseInt(str.substring(1, str.length() - 1));

            sum += Character.isUpperCase(firstLetter) ? number / firstLetterPosition : number * firstLetterPosition;
            sum = Character.isUpperCase(lastLetter) ? sum - lastLetterPosition : sum + lastLetterPosition;
        }

        System.out.printf("%.2f", sum);
    }
}
