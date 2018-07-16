package p10_mood_3.models;

public class Archangel extends Character {

    private int mana;
    private String password;

    public Archangel(String username, String type, int level, int mana) {
        super(username, type, level);
        setMana(mana);
        setPassword();
    }

    private void setPassword() {
        StringBuilder sb = new StringBuilder(super.getUsername()).reverse();
        sb.append(super.getUsername().length() * 21);

        this.password =  sb.toString();
    }

    private void setMana(int mana) {
        this.mana = mana * super.getLevel();
    }

    private int getMana() {
        return this.mana;
    }

    private String getPassword() {
        return this.password;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\"%s\" | \"%s\" -> %s", super.getUsername(), getPassword(), getType()));
        sb.append(System.lineSeparator()).append(getMana());

        return sb.toString();
    }
}
