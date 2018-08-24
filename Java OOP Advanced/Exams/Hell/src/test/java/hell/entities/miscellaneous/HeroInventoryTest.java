package hell.entities.miscellaneous;

import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HeroInventoryTest {

    private Inventory inventory;

    @Before
    public void setUp() {
        this.inventory = new HeroInventory();
    }

    private void setUpMockedItems() {
        Item item = Mockito.mock(Item.class);
        fill(item, "item1");
        Item item2 = Mockito.mock(Item.class);
        fill(item2, "item2");
        Item item3 = Mockito.mock(Item.class);
        fill(item3, "item3");
        this.inventory.addCommonItem(item);
        this.inventory.addCommonItem(item2);
        this.inventory.addCommonItem(item3);
    }

    private void fill(Item item, String name) {
        Mockito.when(item.getAgilityBonus()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(item.getHitPointsBonus()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(item.getDamageBonus()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(item.getStrengthBonus()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(item.getIntelligenceBonus()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(item.getName()).thenReturn(name);
    }

    @Test
    public void getTotalStrengthBonus() {
        setUpMockedItems();
        long actual = this.inventory.getTotalStrengthBonus();
        long expected = (long) Integer.MAX_VALUE * 3;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTotalAgilityBonus() {
        setUpMockedItems();
        long actual = this.inventory.getTotalAgilityBonus();
        long expected = (long) Integer.MAX_VALUE * 3;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTotalIntelligenceBonus() {
        setUpMockedItems();
        long actual = this.inventory.getTotalIntelligenceBonus();
        long expected = (long) Integer.MAX_VALUE * 3;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTotalHitPointsBonus() {
        setUpMockedItems();
        long actual = this.inventory.getTotalHitPointsBonus();
        long expected = (long) Integer.MAX_VALUE * 3;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTotalDamageBonus() {
        setUpMockedItems();
        long actual = this.inventory.getTotalDamageBonus();
        long expected = (long) Integer.MAX_VALUE * 3;

        Assert.assertEquals(expected, actual);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void addCommonItem() {
        this.setUpMockedItems();
        Recipe recipe = Mockito.mock(Recipe.class);
        List<String> itemsNeeded = new ArrayList<>() {{
            add("item1");
            add("item4");
        }};
        Mockito.when(recipe.getRequiredItems()).thenReturn(itemsNeeded);

        Item item = Mockito.mock(Item.class);
        Mockito.when(item.getName()).thenReturn("item4");

        this.inventory.addRecipeItem(recipe);
        this.inventory.addCommonItem(item);

        int actual = 0;
        int expected = 3;

        try {
            Field commonItemsField = this.inventory.getClass().getDeclaredField("commonItems");
            commonItemsField.setAccessible(true);
            Map<String, Item> commonItemsMap = (Map<String, Item>) commonItemsField.get(this.inventory);
            actual = commonItemsMap.size();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addRecipeItem() {
        Recipe item = Mockito.mock(Recipe.class);
        Mockito.when(item.getName()).thenReturn(Long.toHexString(Double.doubleToLongBits(Math.random())));
        this.inventory.addRecipeItem(item);

        int actualSize = 0;
        int expected = 1;

        try {
            Field field = this.inventory.getClass().getDeclaredField("recipeItems");
            field.setAccessible(true);
            Map<String, Recipe> items = (Map<String, Recipe>) field.get(this.inventory);
            actualSize = items.size();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(expected, actualSize);
    }
}
