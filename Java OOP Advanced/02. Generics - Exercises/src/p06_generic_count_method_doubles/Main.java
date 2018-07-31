package p06_generic_count_method_doubles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        List<Double> doubles = new ArrayList<>();
        int n = Integer.parseInt(reader.readLine());
        while (n-- > 0) {
            doubles.add(Double.parseDouble(reader.readLine()));
        }

        double controlDouble = Double.parseDouble(reader.readLine());

        System.out.println(countGreaterStrings(doubles, controlDouble));
    }

    static int countGreaterStrings(List<? extends Comparable> doubles, Double controlDouble) {
        int count = 0;

        for (Comparable dbl : doubles) {
            if (dbl.compareTo(controlDouble) > 0) {
                count++;
            }
        }

        return count;
    }
}
