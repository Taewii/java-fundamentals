package hell.commands;

import hell.Constants;
import hell.entities.miscellaneous.Inject;
import hell.interfaces.*;

public class ItemCommand implements Executable {

    @Inject
    private String[] data;

    @Inject
    private Repository heroes;

    @Inject
    private CommonItemFactory itemFactory;

    @Override
    public String execute() {
        Hero hero = this.heroes.getHero(this.data[2]);
        Item item = this.itemFactory.create(this.data[1],
                Integer.parseInt(this.data[3]),
                Integer.parseInt(this.data[4]),
                Integer.parseInt(this.data[5]),
                Integer.parseInt(this.data[6]),
                Integer.parseInt(this.data[7]));

        hero.addItem(item);

        return String.format(Constants.ADDED_ITEM_TO_HERO, item.getName(), hero.getName());
    }
}
