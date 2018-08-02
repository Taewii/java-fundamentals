package p02_collection;


import java.util.Iterator;

public class ListyIterator<T> implements Iterable<T> {

    private T[] collection;
    private int counter;

    public ListyIterator(T... collection) {
        this.collection = collection;
    }

    public boolean move() {
        if (hasNext()) {
            counter++;
            return true;
        }

        return false;
    }

    public boolean hasNext() {
        return counter < collection.length - 1;
    }

    public void print() {
        if (collection.length == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }
        System.out.println(collection[counter]);
    }

    public void printAll() {
        for (T t : this.collection) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIter();
    }

    private final class ListIter implements Iterator<T> {

        @Override
        public boolean hasNext() {
            return counter < collection.length - 1;
        }

        @Override
        public T next() {
            return collection[counter++];
        }
    }
}
