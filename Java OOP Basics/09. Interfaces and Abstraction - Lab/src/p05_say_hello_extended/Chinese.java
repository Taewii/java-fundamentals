package p05_say_hello_extended;

public class Chinese extends BasePerson {

    Chinese(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void sayHello() {
        System.out.println("Djydjybydjy");
    }
}
