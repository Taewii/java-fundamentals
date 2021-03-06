package p10_tuple;

public class Tuple<A, B> {

    private A item1;
    private B item2;

    public Tuple(A item1, B item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    public A getItem1() {
        return this.item1;
    }

    public void setItem1(A item1) {
        this.item1 = item1;
    }

    public B getItem2() {
        return this.item2;
    }

    public void setItem2(B item2) {
        this.item2 = item2;
    }

    @Override
    public String toString() {
        return getItem1() + " -> " + getItem2();
    }
}
