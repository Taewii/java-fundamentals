package p04_card_toString;

public class Card {

    private Rank cardRank;
    private Suit cardSuit;

    public Card(String cardRank, String cardSuit) {
        this.cardRank = Rank.valueOf(cardRank);
        this.cardSuit = Suit.valueOf(cardSuit);
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d",
                this.cardRank, this.cardSuit,
                this.cardRank.getRankPower() + this.cardSuit.getSuitPower());
    }
}
