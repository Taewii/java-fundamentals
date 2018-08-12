package P01_ExtendedArrayList;


public class Main {
    public static void main(String[] args) {

        ExtendedArrayList<Integer> list = new ExtendedArrayList<>() {{
            add(5);
            add(3);
            add(12);
            add(1);
        }};

        System.out.println(list.min());
        System.out.println(list.max());
    }
}
