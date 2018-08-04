package p05_card_compareTo;

public class Card implements Comparable<Card>{

    private Rank cardRank;
    private Suit cardSuit;

    public Card(String cardRank, String cardSuit) {
        this.cardRank = Rank.valueOf(cardRank);
        this.cardSuit = Suit.valueOf(cardSuit);
    }

    public int getPower() {
        return this.cardRank.getRankPower() + this.cardSuit.getSuitPower();
    }

    @Override
    public int compareTo(Card o) {
        return Integer.compare(this.getPower(), o.getPower());
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d",
                this.cardRank, this.cardSuit, this.getPower());
    }
}
