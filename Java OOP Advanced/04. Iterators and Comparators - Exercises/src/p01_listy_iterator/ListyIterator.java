package p01_listy_iterator;


public class ListyIterator<T> {

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
}
