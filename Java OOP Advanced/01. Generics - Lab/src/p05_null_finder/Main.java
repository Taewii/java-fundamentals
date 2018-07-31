package p05_null_finder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>();
        Collections.addAll(integers, 1, 2, null, 18, 2, null, -1);

        List<String> strings = new ArrayList<>();
        Collections.addAll(strings, null, "a", null, "b", "c");

        List<Integer> nulls = ListUtils.getNullIndices(integers);
        List<Integer> nullsStr = ListUtils.getNullIndices(strings);

        System.out.println(nulls);
        System.out.println(nullsStr);
    }
}
