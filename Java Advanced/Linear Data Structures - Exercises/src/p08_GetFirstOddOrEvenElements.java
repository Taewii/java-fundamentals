import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class p08_GetFirstOddOrEvenElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[] commands = scanner.nextLine().split(" ");

        List<Integer> result = new ArrayList<>();

        int count = Integer.parseInt(commands[1]);
        String oddOrEven = commands[2];

        if (count == 0) {
            return;
        }

        for (int num : nums) {
            if (oddOrEven.equals("even")) {
                if (num % 2 == 0) {
                    result.add(num);
                }
            } else {
                if (num % 2 != 0) {
                    result.add(num);
                }
            }

            if (result.size() == count) {
                break;
            }
        }

        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
    }
}
