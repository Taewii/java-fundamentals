package p04_say_hello;

public class Bulgarian implements Person{

    private String name;

    public Bulgarian(String name) {
        this.name = name;
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}
