import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p02_SplitByWordCasing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> words = Arrays.stream(scanner.nextLine().split("[\\\\,;:.!()\"\'/\\[\\] ]")).collect(Collectors.toList());

        List<String> lowercase = new ArrayList<>();
        List<String> uppercase = new ArrayList<>();
        List<String> mixed = new ArrayList<>();

        for (String word : words) {
            if (word.trim().length() == 0) {
                continue;
            }
            boolean isMixed = false;

            for (int i = 0; i < word.length(); i++) {
                if (!Character.isLetter(word.charAt(i))) {
                    mixed.add(word);
                    isMixed = true;
                    break;
                }
            }

            if (!isMixed) {
                if (word.toUpperCase().equals(word)) {
                    uppercase.add(word);
                } else if (word.toLowerCase().equals(word)) {
                    lowercase.add(word);
                } else {
                    mixed.add(word);
                }
            }
        }

        System.out.println("Lower-case: " + lowercase.toString().replace("[", "").replace("]", ""));
        System.out.println("Mixed-case: " + mixed.toString().replace("[", "").replace("]", ""));
        System.out.println("Upper-case: " + uppercase.toString().replace("[", "").replace("]", ""));
    }
}
