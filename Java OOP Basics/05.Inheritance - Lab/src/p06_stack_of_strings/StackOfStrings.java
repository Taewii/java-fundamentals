package p06_stack_of_strings;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class StackOfStrings {

    private List<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String string) {
        this.data.add(0, string);
    }

    public String pop() {
        if (!this.data.isEmpty()) {
            return this.data.remove(0);
        } else {
            throw new NoSuchElementException();
        }
    }

    public String peek() {
        if (!this.data.isEmpty()) {
            return this.data.get(0);
        } else {
            throw new NoSuchElementException();
        }
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }
}
