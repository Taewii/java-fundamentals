import java.util.Scanner;

public class p03_FormattingNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        int a = Integer.parseInt(input[0]);
        double b = Double.parseDouble(input[1]);
        double c = Double.parseDouble(input[2]);

        String s = Integer.toHexString(a);
        System.out.printf("|%-10s",s.toUpperCase());
        System.out.printf("|%010d|",Integer.parseInt(Integer.toBinaryString(a)));
        System.out.printf("%10.2f",b);
        System.out.printf("|%-10.3f|",c);
    }
}
