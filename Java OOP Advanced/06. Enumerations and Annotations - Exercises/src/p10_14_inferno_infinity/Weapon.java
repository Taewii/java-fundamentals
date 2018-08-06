package p10_14_inferno_infinity;

@CustomAnnotation
public class Weapon implements Comparable<Weapon> {

    private String name;
    private int minDamage;
    private int maxDamage;
    private GemType[] gems;
    private int strength;
    private int agility;
    private int vitality;

    public Weapon(String weaponType, String weaponName) {
        WeaponType type = WeaponType.valueOf(weaponType);
        this.name = weaponName;
        this.minDamage = type.getMinDamage();
        this.maxDamage = type.getMaxDamage();
        this.gems = new GemType[type.getSockets()];
    }

    public void addGem(int index, String gemType) {
        GemType gem = GemType.valueOf(gemType);

        if (index < this.gems.length) {
            if (this.gems[index] != null){
                this.removeGem(index);
            }
            this.gems[index] = gem;
            this.minDamage += (gem.getStrength() * 2) + gem.getAgility();
            this.maxDamage += (gem.getStrength() * 3) + (gem.getAgility() * 4);
            this.strength += gem.getStrength();
            this.agility += gem.getAgility();
            this.vitality += gem.getVitality();
        }
    }

    public void removeGem(int index) {
        if (index < this.gems.length) {
            if (this.gems[index] != null) {
                GemType gem = this.gems[index];
                this.minDamage -= (gem.getStrength() * 2) + gem.getAgility();
                this.maxDamage -= (gem.getStrength() * 3) + (gem.getAgility() * 4);
                this.strength -= gem.getStrength();
                this.agility -= gem.getAgility();
                this.vitality -= gem.getVitality();
                this.gems[index] = null;
            }
        }
    }

//    public void addGemPowersToWeapon() {
//        for (GemType gem : gems) {
//            if (gem != null) {
//                this.minDamage += (gem.getStrength() * 2) + gem.getAgility();
//                this.maxDamage += (gem.getStrength() * 3) + (gem.getAgility() * 4);
//                this.strength += gem.getStrength();
//                this.agility += gem.getAgility();
//                this.vitality += gem.getVitality();
//            }
//        }
//    }

    public double getItemLevel() {
        return ((this.minDamage + this.maxDamage) / 2.0) + this.strength + this.agility + this.vitality;
    }

    @Override
    public int compareTo(Weapon o) {
        return Double.compare(this.getItemLevel(), o.getItemLevel());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(": ").append(this.minDamage).append("-").append(this.maxDamage)
                .append(" Damage, +").append(this.strength)
                .append(" Strength, +").append(this.agility)
                .append(" Agility, +").append(this.vitality)
                .append(" Vitality");

        return sb.toString();
    }

    public String print() {
        return this.toString() + String.format(" (Item Level: %.1f)", this.getItemLevel());
    }
}
