import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

import static java.lang.System.in;

public class BalancedParentheses {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        char[] input = reader.readLine().toCharArray();

        ArrayDeque<Character> stack = new ArrayDeque<>();

        boolean isValid = true;

        for (char c : input) {
            switch (c) {
                case '[':
                case '(':
                case '{':
                    stack.push(c);
                    break;
                case '}':
                    if (stack.isEmpty()) {
                        isValid = false;
                    } else if (stack.poll() != '{') {
                        isValid = false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty()) {
                        isValid = false;
                    } else if (stack.poll() != '[') {
                        isValid = false;
                    }
                    break;
                case ')':
                    if (stack.isEmpty()) {
                        isValid = false;
                    } else if (stack.poll() != '(') {
                        isValid = false;
                    }
                    break;
            }

            if (!isValid) {
                break;
            }
        }
        System.out.println(isValid? "YES" : "NO");
    }
}
