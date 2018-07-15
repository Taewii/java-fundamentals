package p05_say_hello_extended;

public class European extends BasePerson {

    European(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void sayHello() {
        System.out.println("Hello");
    }
}
