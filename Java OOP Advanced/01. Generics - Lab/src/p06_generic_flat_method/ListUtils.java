package p06_generic_flat_method;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {

    @SuppressWarnings("unchecked")
    public static <T extends Comparable> T getMax(List<T> list) {
        T max = list.get(0);

        for (T item : list) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }

    @SuppressWarnings("unchecked")
    public static <T extends Comparable> T getMin(List<T> list) {
        T min = list.get(0);

        for (T item : list) {
            if (item.compareTo(min) < 0) {
                min = item;
            }
        }
        return min;
    }

    public static List<Integer> getNullIndices(List<?> list) {
        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) {
                indices.add(i);
            }
        }

        return indices;
    }

    public static void flatten(List<? super Number> dest, List<List<? extends Number>> source) {

        for (List<? extends Number> numbers : source) {
            dest.addAll(numbers);
        }
    }
}
