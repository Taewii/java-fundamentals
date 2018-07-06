package p05_random_array_list;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {

    private Random rnd = new Random();

    public Object getRandomElement() {
        int index = rnd.nextInt(super.size());
        Object element = super.get(index);
        super.remove(index);

        return element;
    }
}
