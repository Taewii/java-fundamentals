package p09_collection_hierarchy.models;

import p09_collection_hierarchy.contracts.AddCollectionInterface;

import java.util.ArrayList;
import java.util.List;

public class AddCollection implements AddCollectionInterface {

    private List<String> collection;

    public AddCollection() {
        collection = new ArrayList<>();
    }

    @Override
    public int add(String item) {
        int size = this.collection.size();
        this.collection.add(item);
        return size;
    }
}
