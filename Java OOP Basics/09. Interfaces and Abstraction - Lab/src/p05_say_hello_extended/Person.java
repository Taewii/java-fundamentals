package p05_say_hello_extended;

public interface Person {

    String getName();

    default void sayHello() {
        System.out.println("Hello");
    }
}
