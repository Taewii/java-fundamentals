import java.util.Scanner;

public class p05_TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double distance = Double.parseDouble(scanner.nextLine());
        String timeOfDay = scanner.nextLine();

        double price = 0;

        if (distance < 20) {
            if (timeOfDay.equals("day")){
                price = 0.70 + distance * 0.79;
            } else {
                price = 0.70 + distance * 0.90;
            }
        } else if (distance < 100) {
            price = distance * 0.09;
        } else {
            price = distance * 0.06;
        }

        System.out.printf("%.2f", price);
    }
}
