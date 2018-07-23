package app;

import app.contracts.colonies.ColonyInterface;
import app.entities.*;

import java.util.*;
import java.util.stream.Collectors;

public class Colony implements ColonyInterface {

    private int maxFamilyCount;
    private int maxFamilyCapacity;
    private Map<String, Family> families;

    public Colony(int maxFamilyCount, int maxFamilyCapacity) {
        this.maxFamilyCount = maxFamilyCount;
        this.maxFamilyCapacity = maxFamilyCapacity;
        this.families = new LinkedHashMap<>();
    }

    public int getMaxFamilyCapacity() {
        return this.maxFamilyCapacity;
    }

    public int getMaxFamilyCount() {
        return this.maxFamilyCount;
    }

    @Override
    public void addColonist(Colonist colonist) {
        String id = colonist.getFamilyId();

        if (this.families.containsKey(id)) {
            if (this.families.get(id).getSize() == getMaxFamilyCapacity()) {
                throw new IllegalArgumentException("family is full");
            }
        }

        if (this.families.size() == getMaxFamilyCount()) {
            throw new IllegalArgumentException("colony is full");
        }

        this.families.putIfAbsent(id, new Family(id));
        this.families.get(id).addColonist(colonist);
    }

    @Override
    public void removeColonist(String familyId, String memberId) {

    }

    @Override
    public void removeFamily(String id) {

    }

    @Override
    public void grow(int years) {

    }

    @Override
    public int getPotential() {
        return 0;
    }

    @Override
    public String getCapacity() {
        return null;
    }

    @Override
    public List<Colonist> getColonistsByFamilyId(String familyId) {
        List<Colonist> colonists = this.families.get(familyId).getFamilies().stream()
                .sorted(Comparator.comparing(Colonist::getId)).collect(Collectors.toList());

        return Collections.unmodifiableList(colonists);
    }
}
