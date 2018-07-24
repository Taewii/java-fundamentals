package avatar.entities.monuments;

import avatar.contracts.monuments.MonumentInterface;

public abstract class Monument implements MonumentInterface {

    private String name;

    public Monument(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
