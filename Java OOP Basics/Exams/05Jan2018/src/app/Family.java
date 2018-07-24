package app;

import app.entities.Colonist;

import java.util.*;

public class Family {

    private String id;
    private List<Colonist> families;

    protected Family(String id) {
        this.id = id;
        families = new ArrayList<>();
    }

    public String getId() {
        return this.id;
    }

    protected List<Colonist> getFamilies() {
        return Collections.unmodifiableList(this.families);
    }

    protected int getSize() {
        return this.families.size();
    }

    protected void addColonist(Colonist colonist) {
        this.families.add(colonist);
    }

    protected void removeColonist(String id) {
        families.removeIf(colonist -> colonist.getId().equals(id));
    }
}
