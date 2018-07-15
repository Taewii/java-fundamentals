package p04_say_hello;

public class Chinese implements Person{

    private String name;

    public Chinese(String name) {
        this.name = name;
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}
