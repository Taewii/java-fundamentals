package hell.commands;

import hell.Constants;
import hell.entities.miscellaneous.Inject;
import hell.interfaces.Executable;
import hell.interfaces.HeroFactory;
import hell.interfaces.Hero;
import hell.interfaces.Repository;

public class HeroCommand implements Executable {

    @Inject
    private String[] data;

    @Inject
    private Repository heroes;

    @Inject
    private HeroFactory heroFactory;

    @Override
    public String execute() {
        Hero hero =  this.heroFactory.create(this.data[1], this.data[2]);
        this.heroes.addHero(hero);

        return String.format(Constants.CREATED_HERO, hero.getClass().getSimpleName(), hero.getName());
    }
}
