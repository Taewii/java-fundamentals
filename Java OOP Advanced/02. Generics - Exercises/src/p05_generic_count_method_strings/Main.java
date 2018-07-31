package p05_generic_count_method_strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        List<String> strings = new ArrayList<>();
        int n = Integer.parseInt(reader.readLine());
        while (n-- > 0) {
            strings.add(reader.readLine());
        }
        String controlStr = reader.readLine();

        System.out.println(countGreaterStrings(strings, controlStr));
    }

    static int countGreaterStrings(List<? extends Comparable> strings, String controlStr) {
        int count = 0;

        for (Comparable string : strings) {
            if (string.compareTo(controlStr) > 0) {
                count++;
            }
        }

        return count;
    }
}
