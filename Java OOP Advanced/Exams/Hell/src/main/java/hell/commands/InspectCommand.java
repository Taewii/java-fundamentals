package hell.commands;

import hell.entities.miscellaneous.Inject;
import hell.interfaces.Executable;
import hell.interfaces.Repository;

public class InspectCommand implements Executable {

    @Inject
    private String[] data;

    @Inject
    private Repository heroes;

    @Override
    public String execute() {
        return this.heroes.getHero(this.data[1]).toString();
    }
}
