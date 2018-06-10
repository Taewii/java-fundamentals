import java.util.Scanner;

public class p04_CalculateExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        double a = Double.parseDouble(input[0]);
        double b = Double.parseDouble(input[1]);
        double c = Double.parseDouble(input[2]);

        double f1 = Math.pow(((a * a + b * b) / (a * a - b * b)), (a + b + c) / Math.sqrt(c));
        double f2 = Math.pow((a * a + b * b - c * c * c), (a - b));

        double averageOfNums = (a + b + c) / 3;
        double averageOfExpressions = (f1 + f2) / 2;

        double difference = Math.abs(averageOfNums - averageOfExpressions);

        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f", f1, f2, difference);
    }
}
