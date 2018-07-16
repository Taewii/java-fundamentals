package p10_mood_3.models;

public class Demon extends Character {

    private double energy;
    private int password;

    public Demon(String username, String type, int level, double energy) {
        super(username, type,  level);
        setEnergy(energy);
        setPassword();
    }

    private void setPassword() {
        this.password = getUsername().length() * 217;
    }

    private int getPassword() {
        return this.password;
    }

    private void setEnergy(double energy) {
        this.energy = energy * super.getLevel();
    }

    private double getEnergy() {
        return this.energy;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\"%s\" | \"%d\" -> %s", super.getUsername(), getPassword(), getType()));
        sb.append(System.lineSeparator()).append(getEnergy());

        return sb.toString();
    }
}
