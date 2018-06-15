import java.util.Scanner;

public class p07_CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        String first = input[0];
        String second = input[1];

        int sum = 0;

        if (first.length() == second.length()) {
            for (int i = 0; i < first.length(); i++) {
                sum += first.charAt(i) * second.charAt(i);
            }
        } else {
            for (int i = 0; i < Math.min(first.length(), second.length()); i++) {
                sum += first.charAt(i) * second.charAt(i);
            }

            if (first.length() < second.length()) {
               second = second.substring(first.length());

                for (int i = 0; i < second.length(); i++) {
                    sum += second.charAt(i);
                }
            } else {
                first = first.substring(second.length());

                for (int i = 0; i < first.length(); i++) {
                    sum += first.charAt(i);
                }
            }
        }

        System.out.println(sum);
    }
}
