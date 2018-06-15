import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class p05_SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        ArrayDeque<String> calculator = new ArrayDeque<>();

        Collections.addAll(calculator, input);

        while (calculator.size() > 1) {
            int a = Integer.parseInt(calculator.pop());
            String operand = calculator.pop();
            int b = Integer.parseInt(calculator.pop());
            int result = 0;

            switch (operand) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
            }
            calculator.push(result + "");
        }
        System.out.println(calculator.toString().replace("[", "").replace("]", ""));
    }
}
