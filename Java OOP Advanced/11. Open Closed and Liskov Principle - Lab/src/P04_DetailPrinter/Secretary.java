package P04_DetailPrinter;

public class Secretary extends Employee {

    private String number;

    public Secretary(String name, String number) {
        super(name);
        this.number = number;
    }

    @Override
    public String toString() {
        return super.toString() + " Number: " + this.number;
    }
}
