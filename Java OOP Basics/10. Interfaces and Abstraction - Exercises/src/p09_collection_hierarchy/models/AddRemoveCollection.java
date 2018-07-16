package p09_collection_hierarchy.models;

import p09_collection_hierarchy.contracts.AddRemoveCollectionInterface;

import java.util.ArrayList;
import java.util.List;

public class AddRemoveCollection implements AddRemoveCollectionInterface {

    private static final int INDEX = 0;
    private List<String> collection;

    public AddRemoveCollection() {
        this.collection = new ArrayList<>();
    }

    @Override
    public String remove() {
       return this.collection.remove(this.collection.size() - 1);
    }

    @Override
    public int add(String item) {
        this.collection.add(INDEX, item);
        return INDEX;
    }
}
