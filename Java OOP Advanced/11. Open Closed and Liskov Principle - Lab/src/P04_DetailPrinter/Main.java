package P04_DetailPrinter;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Employee dev = new Developer("pesho", "softuni");
        Manager mng = new Manager("gosho", new ArrayList<>() {{
            add("asd");
            add("dsa");
        }});
        Secretary secretary = new Secretary("yovka", "089696969");

        DetailsPrinter dp = new DetailsPrinter(new ArrayList<>() {{
            add(dev);
            add(mng);
            add(secretary);
        }});

        dp.printDetails();
    }
}
