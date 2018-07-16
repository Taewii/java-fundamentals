package p09_collection_hierarchy;

import p09_collection_hierarchy.contracts.AddCollectionInterface;
import p09_collection_hierarchy.contracts.AddRemoveCollectionInterface;
import p09_collection_hierarchy.models.AddCollection;
import p09_collection_hierarchy.models.AddRemoveCollection;
import p09_collection_hierarchy.models.MyList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyList myList = new MyList();

        String[] strings = reader.readLine().split(" ");

        addToCollectionAndPrintIndexes(addCollection, strings);
        addToCollectionAndPrintIndexes(addRemoveCollection, strings);
        addToCollectionAndPrintIndexes(myList, strings);

        int n = Integer.parseInt(reader.readLine());

        printRemovedItems(addRemoveCollection, n);
        printRemovedItems(myList, n);
    }

    private static void addToCollectionAndPrintIndexes(AddCollectionInterface collection, String[] strings) {
        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            sb.append(collection.add(string)).append(" ");
        }
        System.out.println(sb.toString());
    }

    private static void printRemovedItems(AddRemoveCollectionInterface collection, int n) {
        while (n-- > 0) {
            System.out.print(collection.remove() + " ");
        }
        System.out.println();
    }
}
