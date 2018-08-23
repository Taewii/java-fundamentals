package hell.commands;

import hell.entities.miscellaneous.Inject;
import hell.interfaces.Executable;
import hell.interfaces.Repository;

public class QuitCommand implements Executable {

    @Inject
    private Repository heroes;

    @Override
    public String execute() {
        return this.heroes.getStatistics();
    }
}
