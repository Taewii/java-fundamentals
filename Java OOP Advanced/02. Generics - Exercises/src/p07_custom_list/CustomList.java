package p07_custom_list;

import java.util.ArrayList;
import java.util.List;

public class CustomList<T extends Comparable> {

    private List<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        this.list.add(element);
    }

    public T remove(int index) {
        return this.list.remove(index);
    }

    public boolean contains(T element) {
        return this.list.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        T temp = this.list.get(firstIndex);
        this.list.set(firstIndex, this.list.get(secondIndex));
        this.list.set(secondIndex, temp);
    }

    public int countGreaterThan(T element) {
        int count = 0;
        for (T item : list) {
            if (item.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    public T getMax() {
        T max = this.list.get(0);
        for (T t : list) {
            if (t.compareTo(max) > 0) {
                max = t;
            }
        }

        return max;
    }

    public T getMin() {
        T min = this.list.get(0);
        for (T t : list) {
            if (t.compareTo(min) < 0) {
                min = t;
            }
        }
        return min;
    }

    public int getSize() {
        return this.list.size();
    }

    public T get(int index) {
        return this.list.get(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T t : list) {
            sb.append(t).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
