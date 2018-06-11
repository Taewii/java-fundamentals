import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

import static java.lang.System.in;

public class MaximumElement {   // last 2 tests give time limit
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        int n = Integer.parseInt(reader.readLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> maxElement = new ArrayDeque<>();

        int maxNum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            String[] commands = reader.readLine().split(" ");

            if (commands[0].equals("1")) {
                int num = Integer.parseInt(commands[1]);
                stack.push(num);
                if (maxNum <= num) {
                    maxNum = num;
                    maxElement.push(num);
                }
            } else if (commands[0].equals("2")) {
                int popped =  stack.pop();
                if (popped == maxNum) {
                    maxElement.pop();
                    if (maxElement.size() > 0) {
                        maxNum = maxElement.peek();
                    } else {
                        maxNum = Integer.MIN_VALUE;
                    }
                }
            } else if (commands[0].equals("3")) {
                System.out.println(maxNum);
            }
        }
    }
}
