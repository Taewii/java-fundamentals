package p01_generic_box;

public class Box<T> {

    private T element;

    public Box(T element) {
        this.element = element;
    }

    public T getElement() {
        return this.element;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", getElement().getClass().getName(), this.element);
    }
}
