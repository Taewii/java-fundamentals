import java.util.Scanner;

public class p02_TriangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double Ax = scanner.nextDouble();
        double Ay = scanner.nextDouble();
        double Bx = scanner.nextDouble();
        double By = scanner.nextDouble();
        double Cx = scanner.nextDouble();
        double Cy = scanner.nextDouble();

        double area = Math.abs((Ax * (By - Cy) + Bx * (Cy - Ay) + Cx * (Ay - By)) / 2);

        System.out.println((int)area);
    }
}
