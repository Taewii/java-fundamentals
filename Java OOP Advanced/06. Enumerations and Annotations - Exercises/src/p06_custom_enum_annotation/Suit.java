package p06_custom_enum_annotation;

@CustomAnnotation(
        type = "Enumeration",
        category = "Suit",
        description = "Provides suit constants for a Card class.")
public enum Suit {
    CLUBS(0), DIAMONDS(13), HEARTS(26), SPADES(39);

    private int suitPower;

    Suit(int suitPower) {
        this.suitPower = suitPower;
    }

    public int getSuitPower() {
        return this.suitPower;
    }
}
