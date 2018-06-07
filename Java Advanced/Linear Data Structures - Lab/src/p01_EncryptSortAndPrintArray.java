import java.util.*;

public class p01_EncryptSortAndPrintArray {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();

            int sum = 0;
            String vowels = "aeiouAEIOU";

            for (int j = 0; j < name.length(); j++) {
                if (vowels.contains(name.charAt(j) + "")) {
                    sum += name.charAt(j) * name.length();
                } else {
                    sum += name.charAt(j) / name.length();
                }
            }
            list.add(sum);
        }

        Collections.sort(list);
        list.forEach(System.out::println);
    }
}
