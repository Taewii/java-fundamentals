import java.util.Scanner;

public class p09_ExtractABitFromInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int p = scanner.nextInt();

        String bin = Integer.toBinaryString(0x10000 | n).substring(1);
        int index = bin.length() - 1 - p;

        System.out.println(bin.charAt(index));
    }
}
