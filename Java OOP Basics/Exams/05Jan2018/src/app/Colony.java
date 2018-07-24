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

    private int getMaxFamilyCapacity() {
        return this.maxFamilyCapacity;
    }

    private int getMaxFamilyCount() {
        return this.maxFamilyCount;
    }

    @Override
    public void addColonist(Colonist colonist) {
        String id = colonist.getFamilyId();

        if (this.families.containsKey(id)) {
            if (this.families.get(id).getSize() == getMaxFamilyCapacity()) {
                throw new IllegalArgumentException("family is full");
            }
        } else if (this.families.size() == getMaxFamilyCount()) {
            throw new IllegalArgumentException("colony is full");
        }

        this.families.putIfAbsent(id, new Family(id));
        this.families.get(id).addColonist(colonist);
    }

    @Override
    public void removeColonist(String familyId, String memberId) {
        this.families.get(familyId).removeColonist(memberId);
        if (this.families.get(familyId).getSize() == 0) {
            this.families.remove(familyId);
        }
    }

    @Override
    public void removeFamily(String id) {
        this.families.remove(id);
    }

    @Override
    public void grow(int years) {
        for (Family family : families.values()) {
            for (Colonist colonist : family.getFamilies()) {
                colonist.grow(years);
            }
        }
    }

    @Override
    public int getPotential() {
        int totalPotential = 0;

        for (Family family : families.values()) {
            for (Colonist colonist : family.getFamilies()) {
                totalPotential += colonist.getPotential();
            }
        }

        return totalPotential;
    }

    @Override
    public String getCapacity() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("families: %d/%d%n", this.families.size(), this.getMaxFamilyCount()));
        this.families.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(family -> sb.append(String.format("-%s: %d/%d%n",
                        family.getKey(), family.getValue().getSize(), this.getMaxFamilyCapacity())));

        return sb.toString();
    }

    @Override
    public List<Colonist> getColonistsByFamilyId(String familyId) {
        if (!this.families.containsKey(familyId)) {
            throw new IllegalArgumentException("family does not exist");
        }

        List<Colonist> colonists = this.families.get(familyId).getFamilies().stream()
                .sorted(Comparator.comparing(Colonist::getId)).collect(Collectors.toList());

        return Collections.unmodifiableList(colonists);
    }
}
