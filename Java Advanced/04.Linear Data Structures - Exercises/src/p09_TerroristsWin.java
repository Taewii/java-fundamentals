import java.util.Scanner;

public class p09_TerroristsWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        char[] result = input.toCharArray();

        int tempIndex = 0;

        while (input.indexOf('|', tempIndex) != -1) {

            int startIndex = input.indexOf('|', tempIndex);
            int endIndex = input.indexOf('|', startIndex + 1);
            char[] bomb = input.substring(startIndex + 1, endIndex).toCharArray();

            int sum = 0;

            for (char c : bomb) {
                sum += c;
            }

            int power = sum % 10;

            int destroyedLeft = Math.max(0, startIndex - power);
            int destroyedRight = Math.min(input.length() - 1, endIndex + power);

            for (int i = destroyedLeft; i <= destroyedRight; i++) {
                result[i] = '.';
            }

            tempIndex = endIndex + 1;
        }
        System.out.println(result);
    }
}
