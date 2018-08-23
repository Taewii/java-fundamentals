package hell.commands;

import hell.Constants;
import hell.entities.miscellaneous.Inject;
import hell.interfaces.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RecipeCommand implements Executable {

    @Inject
    private String[] data;

    @Inject
    private Repository heroes;

    @Inject
    private RecpieFactory recpieFactory;

    @Override
    public String execute() {
        List<String> items = Arrays.stream(this.data).skip(8).collect(Collectors.toList());
        Hero hero = this.heroes.getHero(this.data[2]);
        Recipe recipe = (Recipe) this.recpieFactory.create(this.data[1],
                Integer.parseInt(this.data[3]),
                Integer.parseInt(this.data[4]),
                Integer.parseInt(this.data[5]),
                Integer.parseInt(this.data[6]),
                Integer.parseInt(this.data[7]),
                items);

        hero.addRecipe(recipe);

        return String.format(Constants.ADDED_RECIPE_TO_HERO, recipe.getName(), hero.getName());
    }
}
