package app;

import app.entities.Colonist;

import java.util.*;

public class Family {

    private String id;
    private List<Colonist> families;

    public Family(String id) {
        this.id = id;
        families = new ArrayList<>();
    }

//    public Map<String, List<Colonist>> getFamilies() {
//        return Collections.unmodifiableMap(this.families);
//    }


    public List<Colonist> getFamilies() {
        return this.families;
    }

    public int getSize() {
        return this.families.size();
    }

//    public void addColonist(Colonist colonist) {
//        this.families.putIfAbsent(colonist.getId(), new ArrayList<>());
//        this.families.get(colonist.getId()).add(colonist);
//    }

    public void addColonist(Colonist colonist) {
        this.families.add(colonist);
    }
}
