package p07_custom_list;


public class Sorter<T extends Comparable<T>> {

    public void sort(CustomList<T> customList) {
        for (int i = 0; i < customList.getSize(); i++) {
            T element = customList.get(i);
            for (int j = i + 1; j < customList.getSize(); j++) {
                T elementToSwap = customList.get(j);
                if (element.compareTo(elementToSwap) > 0) {
                    customList.swap(i, j);
                }
            }
        }
    }
}
