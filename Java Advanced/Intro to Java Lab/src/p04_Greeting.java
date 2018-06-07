import java.util.Scanner;

public class p04_Greeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstName = scanner.nextLine();
        String secondName = scanner.nextLine();

        if (firstName.isEmpty() && secondName.isEmpty()) {
            System.out.println("Hello, ***** *****!");
        } else if (firstName.isEmpty()) {
            System.out.println("Hello, ***** " + secondName + "!");
        } else if (secondName.isEmpty()){
            System.out.println("Hello, " + firstName + " *****!");
        } else {
            System.out.println("Hello, " + firstName + " " + secondName + "!");
        }
    }
}
