import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

import static java.lang.System.in;

public class p02_SumBigNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        BigInteger first = new BigInteger(reader.readLine());
        BigInteger second = new BigInteger(reader.readLine());

        System.out.println(first.add(second));
    }
}
