package p03_stack_iterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Stack<Integer> stack = new Stack<>();
        String input;
        while (!"END".equals(input = reader.readLine())) {
            String[] tokens = input.split(", | ");

            switch (tokens[0]) {
                case "Push":
                    for (int i = 1; i < tokens.length; i++) {
                        stack.push(Integer.parseInt(tokens[i]));
                    }
                    break;
                case "Pop":
                    stack.pop();
                    break;
            }
        }

        for (Object o : stack) {
            System.out.println(o);
        }

        for (Object o : stack) {
            System.out.println(o);
        }
    }
}
