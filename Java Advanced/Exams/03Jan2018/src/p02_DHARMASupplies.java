import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.in;

public class p02_DHARMASupplies {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Pattern isCrate = Pattern.compile("\\[.*?]");
        Pattern validateCrate = Pattern.compile("\\[#([a-z]+|[0-9]+)([A-Za-z0-9\\s]+)#\\1]");

        List<String> allCrates = new ArrayList<>();
        List<String> validCrates = new ArrayList<>();

        int lines = findCrates(reader, isCrate, allCrates);
        int n = allCrates.size() / lines;
        findValidCrates(validateCrate, allCrates, validCrates, n);

        int totalFood = 0;
        int totalDrinks = 0;

        for (String crate : validCrates) {
            Matcher matcher = validateCrate.matcher(crate);
            matcher.find();
            String tag = matcher.group(1);
            String body = matcher.group(2);

            if (Character.isDigit(tag.charAt(0))) {
                int bodySum = Arrays.stream(body.split("")).distinct().mapToInt(x -> x.charAt(0)).sum();
                totalFood += bodySum * tag.length();
            } else {
                int bodySum = Arrays.stream(body.split("")).mapToInt(x -> x.charAt(0)).sum();
                int tagSum = Arrays.stream(tag.split("")).mapToInt(x -> x.charAt(0)).sum();
                totalDrinks += bodySum * tagSum;
            }
        }

        if (validCrates.isEmpty()) {
            System.out.println("No supplies found!");
        } else {
            System.out.println("Number of supply crates: " + validCrates.size());
            System.out.println("Amount of food collected: " + totalFood);
            System.out.println("Amount of drinks collected: " + totalDrinks);
        }
    }

    private static void findValidCrates(Pattern validateCrate, List<String> allCrates, List<String> validCrates, int n) {
        for (String crate : allCrates) {
            Matcher matcher = validateCrate.matcher(crate);

            if (matcher.find()) {
                if (matcher.group(1).length() == n) {
                    validCrates.add(crate);
                }
            }
        }
    }

    private static int findCrates(BufferedReader reader, Pattern isCrate, List<String> allCrates) throws IOException {
        int lines = 0;
        String input;
        while (!"Collect".equals(input = reader.readLine())) {
            Matcher matcher = isCrate.matcher(input);

            while (matcher.find()) {
                allCrates.add(matcher.group(0));
            }
            lines++;
        }
        return lines;
    }
}
