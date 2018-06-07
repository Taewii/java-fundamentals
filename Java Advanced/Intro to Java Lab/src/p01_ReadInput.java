import java.util.Scanner;

public class p01_ReadInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstWord = scanner.next("\\w+");
        String secondWord = scanner.next("\\w+");

        int firstInt = scanner.nextInt();
        int secondInt = scanner.nextInt();
        int thirdInt = scanner.nextInt();
        int sum = firstInt + secondInt + thirdInt;

        scanner.nextLine();

        String thirdWord = scanner.nextLine();


        System.out.println(firstWord + " " + secondWord + " " + thirdWord + " " + sum);
    }
}
