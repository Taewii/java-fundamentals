import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> reversed = new ArrayDeque<>();

        for (int num : nums) {
            reversed.push(num);
        }

        for (int num : reversed) {
            System.out.print(reversed.pop() + " ");
        }
    }
}
