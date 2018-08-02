package p03_stack_iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Stack<T> implements Iterable {

    private List<T> stack;

    public Stack() {
        this.stack = new ArrayList<>();
    }

    public void push(T value) {
        stack.add(0, value);
    }

    public void pop() {
        if (stack.isEmpty()) {
            System.out.println("No elements");
        } else {
            stack.remove(0);
        }
    }

    @Override
    public Iterator iterator() {
        return new StackIterator();
    }

    private final class StackIterator implements Iterator<T> {

        private int counter;

        @Override
        public boolean hasNext() {
            return counter < stack.size();
        }

        @Override
        public T next() {
            return stack.get(counter++);
        }
    }
}
