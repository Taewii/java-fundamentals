package p09_linked_list_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main { // I didn't write this one.. :(
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        LinkedList<Integer> list = new MyLinkedList<>();

        int n = Integer.parseInt(reader.readLine());
        while (n-- > 0) {
            String[] tokens = reader.readLine().split(" ");

            if ("Add".equals(tokens[0])) {
                list.add(Integer.parseInt(tokens[1]));
            } else {
                list.remove(Integer.parseInt(tokens[1]));
            }
        }

        System.out.println(list.getSize());
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}
