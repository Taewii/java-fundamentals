package p04_generic_swap_methods_integers;

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

        List<Integer> integers = new ArrayList<>();
        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0) {
            integers.add(Integer.parseInt(reader.readLine()));
        }

        int[] indexes = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        swap(integers, indexes[0], indexes[1]);

        for (Integer integer : integers) {
            System.out.println(String.format("%s: %s", integer.getClass().getName(), integer));
        }
    }

    static <T> void swap(List<T> list, int firstIndex, int secondIndex) {
        T temp = list.get(firstIndex);
        list.set(firstIndex, list.get(secondIndex));
        list.set(secondIndex, temp);
    }
}
