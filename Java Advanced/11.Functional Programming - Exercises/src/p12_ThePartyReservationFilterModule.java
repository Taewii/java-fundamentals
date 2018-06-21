import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;

public class p12_ThePartyReservationFilterModule { // i didn't write this :(
    private static Predicate<String> currentPredicate;
    private static List<String> list;
    private static List<String> filter = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<>(Arrays.asList(reader.readLine().split("\\s+")));

        while (true) {
            String[] commandLine = reader.readLine().split(";");
            if (commandLine[0].equals("Print")) {
                break;
            }

            Predicate<String> startsWithPredicate = (string) -> string.startsWith(commandLine[2]);
            Predicate<String> endsWithPredicate = (string) -> string.endsWith(commandLine[2]);
            Predicate<String> containsWithPredicate = (string) -> string.contains(commandLine[2]);
            Predicate<String> lengthPredicate = (string) -> string.length() == Integer.parseInt(commandLine[2]);

            switch (commandLine[1]) {
                case "Starts with":
                    currentPredicate = startsWithPredicate;
                    break;
                case "Ends with":
                    currentPredicate = endsWithPredicate;
                    break;
                case "Length":
                    currentPredicate = lengthPredicate;
                    break;
                case "Contains":
                    currentPredicate = containsWithPredicate;
                    break;
            }

            switch (commandLine[0]) {
                case "Remove filter":
                    filter.removeIf(currentPredicate);
                    break;
                case "Add filter":
                    addFilter();
                    break;
            }
        }
        list.removeAll(filter);
        System.out.println(Arrays.toString(list.toArray()).replaceAll("[\\[\\],]", ""));
    }

    private static void addFilter() {
        List<String> result = new ArrayList<>();
        for (String s1 : list) {
            if (currentPredicate.test(s1)) {
                result.add(s1);
            }
        }
        filter.addAll(result);
    }
}
