package p03_generic_swap_method_strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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

        int[] indexes = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        swap(strings, indexes[0], indexes[1]);

        for (String string : strings) {
            System.out.println(String.format("%s: %s", string.getClass().getName(), string));
        }
    }

    static <T> void swap(List<T> list, int firstIndex, int secondIndex) {
        T firstElement = list.get(firstIndex);
        T secondElement = list.get(secondIndex);
        list.add(firstIndex, secondElement);
        list.add(secondIndex + 1, firstElement);
        list.remove(firstIndex + 1);
        list.remove(secondIndex + 1);
    }
}


