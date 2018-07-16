package p09_collection_hierarchy.models;

import p09_collection_hierarchy.contracts.MyListInterface;

import java.util.ArrayList;
import java.util.List;

public class MyList implements MyListInterface {

    private static final int INDEX = 0;
    private List<String> collection;

    public MyList() {
        this.collection = new ArrayList<>();
    }

    @Override
    public int used() {
        return this.collection.size();
    }

    @Override
    public String remove() {
       return this.collection.remove(0);
    }

    @Override
    public int add(String item) {
        this.collection.add(INDEX, item);
        return INDEX;
    }
}
