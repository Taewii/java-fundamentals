import java.math.BigDecimal;
import java.util.Scanner;

public class p03_EuroTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double quantity = Double.parseDouble(scanner.nextLine());
        double pricePerKg = 1.20;

        BigDecimal priceInLeva = new BigDecimal(quantity * pricePerKg);
        BigDecimal priceInMarks = new BigDecimal("4210500000000");
        BigDecimal marks = priceInMarks.multiply(priceInLeva);

        System.out.printf("%.2f marks", marks);
    }
}
