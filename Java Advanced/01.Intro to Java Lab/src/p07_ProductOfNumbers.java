import java.math.BigInteger;
import java.util.Scanner;

public class p07_ProductOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = scanner.nextInt();
        int secondNum = scanner.nextInt();

        BigInteger sum = BigInteger.ONE;

        for (int i = firstNum; i <= secondNum; i++) {
            BigInteger number = new BigInteger("" + i);
            sum = sum.multiply(number);
        }

        System.out.printf("product[%d..%d] = %d", firstNum, secondNum, sum);
    }
}
