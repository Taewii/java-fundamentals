import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p09_ByteParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            list.add(String.format("%8s", Integer.toBinaryString(Integer.parseInt(scanner.nextLine()))).replace(' ', '0'));
        }

        while (true) {
            String input = scanner.nextLine();

            if ("party over".equals(input)) {
                break;
            }

            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            int position = Integer.parseInt(tokens[1]);

            switch (command) {
                case "-1":
                    for (int i = 0; i < list.size(); i++) {
                        String s = list.get(i);
                        if (s.charAt(s.length() - 1 - position) == '1') {
                            converToZero(list, position, i, s);
                        } else {
                            convertToOne(list, position, i, s);
                        }
                    }
                    break;
                case "0":
                    for (int i = 0; i < list.size(); i++) {
                        String s = list.get(i);
                        if (s.charAt(s.length() - 1 - position) == '1') {
                            converToZero(list, position, i, s);
                        }
                    }
                    break;
                case "1":
                    for (int i = 0; i < list.size(); i++) {
                        String s = list.get(i);
                        if (s.charAt(s.length() - 1 - position) == '0') {
                            convertToOne(list, position, i, s);
                        }
                    }
                    break;
            }
        }

        for (String s : list) {
            System.out.println(Integer.parseInt(s, 2));
        }
    }

    private static void convertToOne(List<String> list, int position, int i, String s) {
        char[] charArr = s.toCharArray();
        charArr[s.length() - 1 - position] = '1';
        s = String.valueOf(charArr);
        list.remove(i);
        list.add(i, s);
    }

    private static void converToZero(List<String> list, int position, int i, String s) {
        char[] charArr = s.toCharArray();
        charArr[s.length() - 1 - position] = '0';
        s = String.valueOf(charArr);
        list.remove(i);
        list.add(i, s);
    }
}
