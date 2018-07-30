package p01_jar_of_t;

public class Main {
    public static void main(String[] args) {

        Jar<Integer> numbers = new Jar<>() {{
            add(5);
            add(4);
            add(3);
        }};

        System.out.println(numbers.remove());
    }
}
