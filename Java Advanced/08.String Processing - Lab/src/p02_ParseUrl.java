    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;

    import static java.lang.System.in;

    public class p02_ParseUrl {
        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String[] input = reader.readLine().split("://");

            if (input.length != 2) {
                System.out.println("Invalid URL");
                return;
            }

            String protocol = input[0];
            String serverAndResources = input[1];
            int index = serverAndResources.indexOf("/");
            String server = serverAndResources.substring(0, index);
            String resources = serverAndResources.substring(index + 1);

            System.out.println("Protocol = " + protocol);
            System.out.println("Server = " + server);
            System.out.println("Resources = " + resources);
        }
    }
