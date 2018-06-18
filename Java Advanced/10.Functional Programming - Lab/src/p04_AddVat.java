import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

import static java.lang.System.in;

public class p04_AddVat {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        double[] input = Arrays.stream(reader.readLine().split(", ")).mapToDouble(Double::parseDouble).toArray();

        Function<double[], double[]> addVat = a -> {
          double[] vats = new double[a.length];
            for (int i = 0; i < a.length; i++) {
                vats[i] = a[i] * 1.2;
            }
            return vats;
        };

        double[] afterVat = addVat.apply(input);

        Consumer<double[]> print = a -> {
            System.out.println("Prices with VAT:");
            for (double num : a) {
                System.out.printf("%.2f%n", num);
            }
        };

        print.accept(afterVat);
    }
}
