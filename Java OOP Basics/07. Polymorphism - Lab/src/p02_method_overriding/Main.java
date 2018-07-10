package p02_method_overriding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0) {
            double[] nums = Arrays.stream(reader.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

            if (nums.length == 1) {
                Rectangle square = new Square(nums[0]);
                System.out.println(square.area());
            } else {
                Rectangle rectangle = new Rectangle(nums[0], nums[1]);
                System.out.println(rectangle.area());
            }
        }
    }
}
