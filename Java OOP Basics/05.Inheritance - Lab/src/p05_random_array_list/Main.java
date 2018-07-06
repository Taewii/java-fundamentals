package p05_random_array_list;

public class Main {
    public static void main(String[] args) {

        RandomArrayList list = new RandomArrayList();

        list.add(4);
        list.add(123);
        list.add(34);
        list.add(64);
        list.add(3);

        System.out.println(list.getRandomElement());
    }
}
