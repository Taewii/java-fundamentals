package p04_list_utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>();
        Collections.addAll(integers, 1, 2, 18, 2, -1);

        List<String> strings = new ArrayList<>();
        Collections.addAll(strings, "a", "b", "c");

        Integer max = ListUtils.getMax(integers);
        Integer min = ListUtils.getMin(integers);

        String maxStr = ListUtils.getMax(strings);
        String minStr = ListUtils.getMin(strings);

        System.out.println(max);
        System.out.println(min);
        System.out.println(maxStr);
        System.out.println(minStr);
    }
}
