import java.util.Scanner;

public class p10_ModifyABit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int p = scanner.nextInt();
        String v = scanner.next();

        String bin = Integer.toBinaryString(0x10000 | n).substring(1);
        int index = bin.length() - 1 - p;

        char[] binChars = bin.toCharArray();
        binChars[index] = v.toCharArray()[0];
        bin = String.valueOf(binChars);

        int num = Integer.parseInt(bin, 2);

        System.out.println(num);
    }
}
