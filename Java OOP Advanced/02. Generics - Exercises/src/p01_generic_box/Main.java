package p01_generic_box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0) {
            Box<String> str = new Box<>(reader.readLine());
            System.out.println(str);
        }
    }
}
