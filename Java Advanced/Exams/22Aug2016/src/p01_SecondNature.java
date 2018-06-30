import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class p01_SecondNature {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Deque<Integer> flowers = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        Deque<Integer> buckets = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        List<Integer> secondNature = new ArrayList<>();

        while (!flowers.isEmpty() && !buckets.isEmpty()) {
            int bucket = buckets.pollLast();
            int flower = flowers.peek();

            if (bucket < flower) {
                flower = flowers.pop() - bucket;
                flowers.push(flower);
            } else {
                if (flower - bucket == 0) {
                    secondNature.add(flower);
                } else {
                    if (!buckets.isEmpty()) {
                        int lastBucket = buckets.pollLast();
                        buckets.add(lastBucket + (bucket - flower));
                    } else {
                        buckets.add(bucket - flower);
                    }
                }
                flowers.remove();
            }
        }

        if (flowers.isEmpty()) {
            System.out.println(buckets.toString().replaceAll("[\\[\\],]", ""));
        } else {
            System.out.println(flowers.toString().replaceAll("[\\[\\],]", ""));
        }
        System.out.println(secondNature.size() == 0 ? "None" : secondNature.toString().replaceAll("[\\[\\],]", ""));
    }
}
