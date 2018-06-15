import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.lang.System.in;

public class p07_FixEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Map<String, String> emails = new LinkedHashMap<>();

        String name;
        while (!"stop".equals(name = reader.readLine())) {
            String email = reader.readLine();

            if (!(email.endsWith(".com") || email.endsWith(".us") || email.endsWith(".uk"))) {
                emails.put(name, email);
            }
        }

        for (Map.Entry<String, String> emailsEntry : emails.entrySet()) {
            System.out.printf("%s -> %s%n", emailsEntry.getKey(), emailsEntry.getValue());
        }
    }
}
