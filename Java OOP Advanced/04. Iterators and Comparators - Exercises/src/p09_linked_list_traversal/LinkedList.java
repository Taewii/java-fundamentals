package p09_linked_list_traversal;

public interface LinkedList<E> extends Iterable<E>  {
    int getSize();

    void add(E element);

    boolean remove(E element);
}
