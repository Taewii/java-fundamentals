package p04_froggy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lake<T> implements Iterable<T> {

    private List<T> numbers;

    public Lake(List<T> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    @Override
    public Iterator<T> iterator() {
        return new Frog();
    }

    public class Frog implements Iterator<T> {

        private int count;
        private int cursor;
        private boolean hasSetToOdd;

        @Override
        public boolean hasNext() {
            return this.count != numbers.size();
        }

        @Override
        public T next() {
            this.count++;

            if (this.cursor < numbers.size()) {
                int currentCursor = this.cursor;
                this.cursor += 2;
                return numbers.get(currentCursor);
            } else {
                if (!this.hasSetToOdd) {
                    this.cursor = 1;
                    this.hasSetToOdd = true;
                }

                int currentCursor = this.cursor;
                this.cursor += 2;
                return numbers.get(currentCursor);
            }
        }
    }
}
