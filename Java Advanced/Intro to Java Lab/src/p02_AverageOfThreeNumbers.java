import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.DoubleStream;

public class p02_AverageOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] nums = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

        double average = DoubleStream.of(nums).sum() / 3;

        System.out.printf("%.2f", average);
    }
}
