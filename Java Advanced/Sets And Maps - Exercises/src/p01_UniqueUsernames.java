import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

import static java.lang.System.in;

public class p01_UniqueUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Set<String> usernames = new LinkedHashSet<>();

        int n = Integer.parseInt(reader.readLine());

        while (n-- != 0) {
            String name = reader.readLine();
            usernames.add(name);
        }

        for (String username : usernames) {
            System.out.println(username);
        }
    }
}
