package p06_stack_of_strings;

public class Main {
    public static void main(String[] args) {

        StackOfStrings sos = new StackOfStrings();

        sos.push("one");
        sos.push("two");
        sos.push("three");

        System.out.println(sos.isEmpty());

        while (!sos.isEmpty()){
            System.out.println(sos.pop());
        }
    }
}


